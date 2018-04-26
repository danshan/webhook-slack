package com.shanhh.webhook.microbadger.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
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

    @Test
    public void exec() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "  \"text\":\"MicroBadger: Docker Hub image org/name has changed\",\n" +
                "  \"image_name\":\"org/name\",\n" +
                "  \"new_tags\":[],\n" +
                "  \"changed_tags\":[\n" +
                "    {\n" +
                "      \"tag\":\"latest\",\n" +
                "      \"SHA\":\"123456789a....\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"deleted_tags\":[]\n" +
                "}";
        MicrobadgerPayload payload = objectMapper.readValue(json.getBytes(Charsets.UTF_8), MicrobadgerPayload.class);
        SlackPayload exec = microbadgerService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));

    }

}