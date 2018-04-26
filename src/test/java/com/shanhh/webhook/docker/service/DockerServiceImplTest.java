package com.shanhh.webhook.docker.service;

import com.google.gson.Gson;
import com.shanhh.webhook.PayloadUtils;
import com.shanhh.webhook.integration.docker.beans.DockerPayload;
import com.shanhh.webhook.integration.docker.service.DockerService;
import com.shanhh.webhook.integration.docker.service.DockerServiceImpl;
import com.shanhh.webhook.repo.entity.SlackAttaPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

/**
 * @author dan
 * @since 2017-03-13 16:38
 */
public class DockerServiceImplTest {

    private DockerService dockerService = new DockerServiceImpl();
    private static final Gson gson = new Gson();

    @Test
    public void exec() throws IOException {
        String json = PayloadUtils.readPayload("docker/image_pushed.json");
        DockerPayload payload = gson.fromJson(json, DockerPayload.class);
        SlackPayload exec = dockerService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));

    }

}