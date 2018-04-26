package com.shanhh.webhook.service;

import com.shanhh.webhook.repo.entity.Hook;
import com.shanhh.webhook.repo.entity.SlackPayload;

/**
 * @author dan
 * @since 2017-03-03 22:40
 */
public interface SlackService {

    String send(Hook hook, SlackPayload payload);

}
