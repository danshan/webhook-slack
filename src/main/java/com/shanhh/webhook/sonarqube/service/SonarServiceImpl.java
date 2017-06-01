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
            payload.getQualityGate().getConditions().stream()
                    .filter(condition -> !"OK".equals(condition.getStatus()))
                    .forEach(condition -> {
                        SlackAttaPayload.Attachment attachment = SlackAttaPayload.Attachment.builder()
                                .color(SlackAttaColor.danger.name())
                                .title(condition.getMetric())
                                .text(String.format("%s %s %s `%s`",
                                        condition.getMetric(),
                                        condition.getOperator(),
                                        condition.getErrorThreshold(),
                                        "NO_VALUE".equals(condition.getStatus()) ? "NA" : condition.getValue()))
                                .mrkdwnIn(Arrays.asList("text"))
                                .build();
                        attachments.add(attachment);
                    });
        }
        while (attachments.size() > 30) {
            attachments.remove(attachments.size() - 1);
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
