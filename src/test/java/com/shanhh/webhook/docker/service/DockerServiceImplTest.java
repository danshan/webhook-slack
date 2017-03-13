package com.shanhh.webhook.docker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.shanhh.webhook.docker.beans.DockerPayload;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

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

    @Test
    public void exec() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "    {\n" +
                "        \"callback_url\": \"https://registry.hub.docker.com/u/svendowideit/testhook/hook/2141b5bi5i5b02bec211i4eeih0242eg11000a/\",\n" +
                "        \"push_data\": {\n" +
                "            \"images\": [\n" +
                "                \"27d47432a69bca5f2700e4dff7de0388ed65f9d3fb1ec645e2bc24c223dc1cc3\",\n" +
                "                \"51a9c7c1f8bb2fa19bcd09789a34e63f35abb80044bc10196e304f6634cc582c\",\n" +
                "                \"...\"\n" +
                "            ],\n" +
                "            \"pushed_at\": 1.417566161e+09,\n" +
                "            \"pusher\": \"trustedbuilder\"\n" +
                "        },\n" +
                "        \"repository\": {\n" +
                "            \"comment_count\": \"0\",\n" +
                "            \"date_created\": 1.417494799e+09,\n" +
                "            \"description\": \"\",\n" +
                "            \"dockerfile\": \"\",\n" +
                "            \"full_description\": \"Docker Hub based automated build from a GitHub repo\",\n" +
                "            \"is_official\": false,\n" +
                "            \"is_private\": true,\n" +
                "            \"is_trusted\": true,\n" +
                "            \"name\": \"testhook\",\n" +
                "            \"namespace\": \"svendowideit\",\n" +
                "            \"owner\": \"svendowideit\",\n" +
                "            \"repo_name\": \"svendowideit/testhook\",\n" +
                "            \"repo_url\": \"https://registry.hub.docker.com/u/svendowideit/testhook/\",\n" +
                "            \"star_count\": 0,\n" +
                "            \"status\": \"Active\"\n" +
                "        }\n" +
                "    }";
        DockerPayload payload = objectMapper.readValue(json.getBytes(Charsets.UTF_8), DockerPayload.class);
        SlackPayload exec = dockerService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));

    }

}