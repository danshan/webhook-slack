package com.shanhh.webhook.daocloud.service;

import com.shanhh.webhook.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

/**
 * @author dan
 * @since 2017-03-03 22:37
 */
public interface DaocloudService {
    SlackPayload exec(DaocloudPayload payload);
}
