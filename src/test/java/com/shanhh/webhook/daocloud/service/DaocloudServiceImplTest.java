package com.shanhh.webhook.daocloud.service;

import com.google.gson.Gson;
import com.shanhh.webhook.PayloadUtils;
import com.shanhh.webhook.integration.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.integration.daocloud.service.DaocloudServiceImpl;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author dan
 * @since 2017-03-06 09:45
 */
public class DaocloudServiceImplTest {

    private DaocloudServiceImpl daocloudService = new DaocloudServiceImpl();
    private static final Gson gson = new Gson();

    @Test
    public void exec() throws Exception {
        SlackPayload exec = daocloudService.exec(readPayload("build_success"));
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));
    }

    @Test
    public void testSkip() throws Exception {
        assertNull(daocloudService.exec(readPayload("build_queue")));
        assertNull(daocloudService.exec(readPayload("build_started")));
        assertNotNull(daocloudService.exec(readPayload("build_error")));
    }

    private DaocloudPayload readPayload(String filename) throws IOException {
        String json = PayloadUtils.readPayload(String.format("daocloud/%s.json", filename));
        return gson.fromJson(json, DaocloudPayload.class);
    }

}