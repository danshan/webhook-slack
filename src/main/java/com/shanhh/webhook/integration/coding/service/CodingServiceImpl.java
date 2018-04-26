package com.shanhh.webhook.integration.coding.service;

import com.google.common.collect.Lists;
import com.shanhh.webhook.integration.coding.beans.CodingPushPayload;
import com.shanhh.webhook.repo.entity.SlackAttaColor;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author dan
 * @since 2017-06-01 17:20
 */
@Service
public class CodingServiceImpl implements CodingService {

    @Override
    public SlackPayload exec(CodingPushPayload payload) {
        if (checkSkip(payload)) {
            return null;
        }

        SlackAttaPayload slack = new SlackAttaPayload();

        List<SlackAttaPayload.Attachment> attachments = Lists.newLinkedList();
        SlackAttaPayload.Attachment.AttachmentBuilder builder = SlackAttaPayload.Attachment.builder()
                .color(SlackAttaColor.good.name())
//                .title(payload.getRef())
                .mrkdwnIn(Arrays.asList("text"));
        if (!CollectionUtils.isEmpty(payload.getCommits())) {
            StringBuilder text = new StringBuilder();
            payload.getCommits().stream()
                    .forEach(commit -> {
                        text.append("* ").append(commit.getCommitter().getName()).append(": ").append(commit.getShortMessage()).append("\n");
                    });
            builder.text(text.toString());
        }
        attachments.add(builder.build());

        slack.setText(String.format("*%s* updated `%s`", payload.getRepository().getName(), payload.getRef()));
        slack.setAttachments(attachments);
        slack.setMrkdwnIn(Arrays.asList("text"));

        return slack;
    }

    private boolean checkSkip(CodingPushPayload payload) {
        return false;
    }


}
