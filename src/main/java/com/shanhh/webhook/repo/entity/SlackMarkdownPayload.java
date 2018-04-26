package com.shanhh.webhook.repo.entity;

import lombok.Data;

/**
 * @author dan
 * @since 2017-03-03 22:23
 */
@Data
public class SlackMarkdownPayload implements SlackPayload {

    private String text;
    private String username;
    private boolean mrkdwn;

}
