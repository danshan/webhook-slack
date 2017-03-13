package com.shanhh.webhook.docker.service;

import com.shanhh.webhook.docker.beans.DockerPayload;
import com.shanhh.webhook.slack.beans.SlackAttaColor;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;

import java.util.Arrays;

/**
 * @author dan
 * @since 2017-03-13 15:57
 */
@Service
@Slf4j
public class DockerServiceImpl implements DockerService {

    @Override
    public SlackPayload exec(DockerPayload payload) {
        SlackAttaPayload slack = new SlackAttaPayload();

        SlackAttaPayload.Attachment attachment = SlackAttaPayload.Attachment.builder()
                .title(payload.getRepository().getRepoName())
                .titleLink(payload.getRepository().getRepoUrl())
                .text(String.format("%s build `%s`", payload.getRepository().getRepoName(), payload.getRepository().getStatus()))
                .fallback(String.format("%s build %s", payload.getRepository().getRepoName(), payload.getRepository().getStatus()))
                .color(SlackAttaColor.good.name())
                .mrkdwnIn(Arrays.asList("text"))
//                .authorName(payload.getBuild().getAuthor())
//                .fields(fields)
                .build();

        slack.setAttachments(Arrays.asList(attachment));
        return slack;

    }

}
