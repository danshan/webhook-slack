package com.shanhh.webhook.integration.daocloud.service;

import com.shanhh.webhook.integration.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;

/**
 * @author dan
 * @since 2017-03-03 22:37
 */
public interface DaocloudService {
    SlackPayload exec(DaocloudPayload payload);
}
