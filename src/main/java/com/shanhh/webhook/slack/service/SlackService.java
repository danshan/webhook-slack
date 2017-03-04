package com.shanhh.webhook.slack.service;

import com.shanhh.webhook.slack.beans.Hook;
import com.shanhh.webhook.slack.beans.SlackPayload;

/**
 * @author dan
 * @since 2017-03-03 22:40
 */
public interface SlackService {

    String send(Hook hook, SlackPayload payload);

}
