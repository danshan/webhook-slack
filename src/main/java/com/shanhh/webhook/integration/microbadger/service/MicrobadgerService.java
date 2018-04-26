package com.shanhh.webhook.integration.microbadger.service;

import com.shanhh.webhook.integration.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;

/**
 * @author dan
 * @since 2017-03-05 23:45
 */
public interface MicrobadgerService {
    SlackPayload exec(MicrobadgerPayload payload);
}
