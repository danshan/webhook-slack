package com.shanhh.webhook.microbadger.service;

import com.shanhh.webhook.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

/**
 * @author dan
 * @since 2017-03-05 23:45
 */
public interface MicrobadgerService {
    SlackPayload exec(MicrobadgerPayload payload);
}
