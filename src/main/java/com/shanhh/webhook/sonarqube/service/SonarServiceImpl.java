package com.shanhh.webhook.sonarqube.service;

import com.google.common.collect.Lists;
import com.shanhh.webhook.slack.beans.SlackAttaColor;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;
import com.shanhh.webhook.sonarqube.beans.SonarPayload;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-21 17:38
 */
@Slf4j
@Service
public class SonarServiceImpl implements SonarService {

    @Override
    public SlackPayload exec(SonarPayload payload) {
        if (checkSkip(payload)) {
            return null;
        }

        SlackAttaPayload slack = new SlackAttaPayload();

        List<SlackAttaPayload.Attachment> attachments = Lists.newLinkedList();
        if (payload.getQualityGate() != null && !CollectionUtils.isEmpty(payload.getQualityGate().getConditions())) {
            StringBuilder text = new StringBuilder();
            SlackAttaPayload.Attachment.AttachmentBuilder builder = SlackAttaPayload.Attachment.builder()
                    .color(SlackAttaColor.danger.name())
                    .mrkdwnIn(Arrays.asList("text"));
            payload.getQualityGate().getConditions().stream()
                    .filter(condition -> !"OK".equals(condition.getStatus()))
                    .forEach(condition -> {
                        text.append("* ").append(condition.getMetric()).append(" ").append(condition.getStatus())
                                .append(": ").append(condition.getOperator())
                                .append(" ").append(condition.getErrorThreshold())
                                .append(" `").append("NO_VALUE".equals(condition.getStatus()) ? "NA" : condition.getValue()).append("`")
                                .append("\n");
                    });
            builder.text(text.toString());
            attachments.add(builder.build());
        }

        slack.setText(String.format("%s: `%s`", payload.getProject().getName(), payload.getStatus()));
        slack.setAttachments(attachments);
        slack.setMrkdwnIn(Arrays.asList("text"));
        return slack;
    }

    private boolean checkSkip(SonarPayload payload) {
        return false;
    }
}
