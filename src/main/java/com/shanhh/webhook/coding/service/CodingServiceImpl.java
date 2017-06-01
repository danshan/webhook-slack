package com.shanhh.webhook.coding.service;

import com.shanhh.webhook.coding.beans.CodingPushPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

import org.springframework.stereotype.Service;

/**
 * @author dan
 * @since 2017-06-01 17:20
 */
@Service
public class CodingServiceImpl implements CodingService {

    @Override
    public SlackPayload exec(CodingPushPayload payload) {
        return null;
    }


}
