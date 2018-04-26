package com.shanhh.webhook.integration.coding.service;

import com.shanhh.webhook.integration.coding.beans.CodingPushPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;

/**
 * @author dan
 * @since 2017-06-01 17:16
 */
public interface CodingService {
    SlackPayload exec(CodingPushPayload payload);
}
