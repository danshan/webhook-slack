package com.shanhh.webhook.integration.coding.service;

import com.google.common.collect.Lists;
import com.shanhh.webhook.integration.coding.beans.CodingPingPayload;
import com.shanhh.webhook.integration.coding.beans.CodingPushPayload;
import com.shanhh.webhook.repo.entity.SlackAttaColor;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackMarkdownPayload;
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
        SlackAttaPayload slack = new SlackAttaPayload();

        List<SlackAttaPayload.Attachment> attachments = Lists.newLinkedList();
        SlackAttaPayload.Attachment.AttachmentBuilder builder = SlackAttaPayload.Attachment.builder()
                .color(SlackAttaColor.good.name())
//                .title(payload.getRef())
                .mrkdwnIn(Arrays.asList("text"));
        if (!CollectionUtils.isEmpty(payload.getCommits())) {
            StringBuilder text = new StringBuilder();
            payload.getCommits().forEach(commit -> {
                text.append(String.format("* <%s|%s> %s: %s",
                        commit.getUrl(),
                        commit.getId().substring(0, 7),
                        commit.getCommitter().getName(),
                        commit.getMessage()
                )).append("\n");
            });
            builder.text(text.toString());
        }
        attachments.add(builder.build());

        slack.setText(String.format("%s pushed <%s|%s> `<%s|%s>`",
                payload.getPusher().getName(),
                payload.getRepository().getHtmlUrl(),
                payload.getRepository().getName(),
                payload.getCompare(),
                payload.getRef()));
        slack.setAttachments(attachments);
        slack.setMrkdwnIn(Arrays.asList("text"));

        return slack;
    }

    @Override
    public SlackPayload exec(CodingPingPayload payload) {
        SlackMarkdownPayload slack = new SlackMarkdownPayload();
        slack.setMrkdwn(true);
        slack.setText(String.format("<%s|%s> ping <%s|%s>",
                payload.getSender().getUrl(), payload.getSender().getName(),
                payload.getRepository().getUrl(), payload.getRepository().getFullName()));
        return slack;
    }

}
