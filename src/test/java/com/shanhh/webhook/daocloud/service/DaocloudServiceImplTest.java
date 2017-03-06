package com.shanhh.webhook.daocloud.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.shanhh.webhook.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author dan
 * @since 2017-03-06 09:45
 */
public class DaocloudServiceImplTest {

    private DaocloudServiceImpl daocloudService = new DaocloudServiceImpl();

    @Test
    public void exec() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{\n" +
                "        \"repo\":\"daocloud/api\",\n" +
                "        \"image\":\"daocloud.io/daocloud/api:master-init\",\n" +
                "        \"build_flow_id\":\"8d7622ea-9323-4489-8c8e-fc4bed448961\",\n" +
                "        \"name\":\"api\",\n" +
                "        \"build\":\n" +
                "        {\n" +
                "            \"status\":\"Success\",\n" +
                "            \"duration_seconds\":180,\n" +
                "            \"author\":\"DaoCloud\",\n" +
                "            \"triggered_by\":\"tag\",\n" +
                "            \"sha\":\"a7c35d9dc7e93788ce81befbadeb0108de495e5e\",\n" +
                "            \"tag\":\"master-init\",\n" +
                "            \"branch\":null,\n" +
                "            \"pull_request\":\"\",\n" +
                "            \"message\":\"init build \",\n" +
                "            \"started_at\":\"2015-01-01T08:20:00+00:00\",\n" +
                "            \"build_type\":\"image_build\"}\n" +
                "        }\n" +
                "    }";
        DaocloudPayload payload = objectMapper.readValue(json.getBytes(Charsets.UTF_8), DaocloudPayload.class);
        SlackPayload exec = daocloudService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getFallback()));

    }

}