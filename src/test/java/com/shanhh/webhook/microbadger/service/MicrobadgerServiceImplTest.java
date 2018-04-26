package com.shanhh.webhook.microbadger.service;

import com.google.gson.Gson;
import com.shanhh.webhook.PayloadUtils;
import com.shanhh.webhook.integration.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.integration.microbadger.service.MicrobadgerServiceImpl;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author dan
 * @since 2017-03-06 09:09
 */
public class MicrobadgerServiceImplTest {

    private MicrobadgerServiceImpl microbadgerService = new MicrobadgerServiceImpl();
    private static final Gson gson = new Gson();

    @Test
    public void exec() throws Exception {
        String json = PayloadUtils.readPayload("microbadger/image_changed.json");
        MicrobadgerPayload payload = gson.fromJson(json, MicrobadgerPayload.class);
        SlackPayload exec = microbadgerService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));

    }

}