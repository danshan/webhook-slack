package com.shanhh.webhook.daocloud.service;

import com.google.common.collect.Lists;
import com.shanhh.webhook.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.slack.beans.SlackAttaColor;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author dan
 * @since 2017-03-03 22:37
 */
@Service
@Slf4j
public class DaocloudServiceImpl implements DaocloudService {


    @Override
    public SlackPayload exec(DaocloudPayload payload) {
        if (checkSkip(payload)) {
            return null;
        }

        SlackAttaPayload slack = new SlackAttaPayload();

        List<SlackAttaPayload.Attachment.Field> fields = Lists.newLinkedList();
        fields.add(SlackAttaPayload.Attachment.Field.builder()
                .isShort(true)
                .title("Triggered By")
                .value(payload.getBuild().getTriggeredBy())
                .build());
        fields.add(SlackAttaPayload.Attachment.Field.builder()
                .isShort(true)
                .title("Duration")
                .value(payload.getBuild().getDurationSeconds() + " s")
                .build());
        fields.add(SlackAttaPayload.Attachment.Field.builder()
                .isShort(false)
                .title("SHA")
                .value(payload.getBuild().getSha())
                .build());
        if (StringUtils.isNotBlank(payload.getBuild().getTag())) {
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .isShort(true)
                    .title("Tag")
                    .value(payload.getBuild().getTag())
                    .build());
        }

        if (StringUtils.isNotBlank(payload.getBuild().getBranch())) {
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .isShort(true)
                    .title("Branch")
                    .value(payload.getBuild().getBranch())
                    .build());
        }

        if (StringUtils.isNotBlank(payload.getBuild().getPullRequest())) {
            fields.add(SlackAttaPayload.Attachment.Field.builder()
                    .isShort(false)
                    .title("Pull Request")
                    .value(payload.getBuild().getPullRequest())
                    .build());
        }

        SlackAttaPayload.Attachment attachment = SlackAttaPayload.Attachment.builder()
                .title(payload.getImage())
                .titleLink("https://dashboard.daocloud.io/build-flows/" + payload.getBuildFlowId())
                .text(buildText(payload))
                .fallback(buildFallback(payload))
                .color(selectColor(payload.getBuild().getStatus()))
                .mrkdwnIn(Arrays.asList("text"))
//                .authorName(payload.getBuild().getAuthor())
                .fields(fields)
                .build();

        slack.setAttachments(Arrays.asList(attachment));
        return slack;
    }

    private boolean checkSkip(DaocloudPayload payload) {
        switch (payload.getBuild().getStatus()) {
            case "Success":
            case "Failure":
            case "Error":
//            case "Started":
                return false;
            default:
                return true;
        }
    }

    private String buildText(DaocloudPayload payload) {
        return String.format("*%s* %s `%s`",
                payload.getRepo(),
                buildOperation(payload),
                payload.getBuild().getStatus());

    }

    private String buildFallback(DaocloudPayload payload) {
        return String.format("%s %s %s",
                payload.getRepo(),
                buildOperation(payload),
                payload.getBuild().getStatus());

    }

    private Object buildOperation(DaocloudPayload payload) {
        switch (payload.getBuild().getBuildType()) {
            case "image_build":
                return "image build";
            case "ci_build":
                return "ci build";
            default:
                return "build";
        }
    }

    private String selectColor(String status) {
        switch (status) {
            case "Success":
                return SlackAttaColor.good.name();
            case "Failure":
                return SlackAttaColor.warning.name();
            case "Error":
                return SlackAttaColor.danger.name();
            case "Started":
                return "#6ad8e6";
            default:
                return SlackAttaColor.warning.name();
        }
    }
}
