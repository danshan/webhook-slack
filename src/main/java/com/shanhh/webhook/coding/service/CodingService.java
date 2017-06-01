package com.shanhh.webhook.coding.service;

import com.shanhh.webhook.coding.beans.CodingPushPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

/**
 * @author dan
 * @since 2017-06-01 17:16
 */
public interface CodingService {
    SlackPayload exec(CodingPushPayload payload);
}
