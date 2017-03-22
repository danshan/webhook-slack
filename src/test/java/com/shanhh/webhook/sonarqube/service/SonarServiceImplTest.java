package com.shanhh.webhook.sonarqube.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Charsets;
import com.shanhh.webhook.slack.beans.SlackAttaPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;
import com.shanhh.webhook.sonarqube.beans.SonarPayload;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author dan
 * @since 2017-03-22 09:13
 */
public class SonarServiceImplTest {
    private SonarService sonarService = new SonarServiceImpl();

    @Test
    public void exec() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "    {\n" +
                "        \"analysedAt\": \"2016-11-18T10:46:28+0100\",\n" +
                "        \"project\": {\n" +
                "            \"key\": \"org.sonarqube:example\",\n" +
                "            \"name\": \"Example\"\n" +
                "        },\n" +
                "        \"properties\": {\n" +
                "        },\n" +
                "        \"qualityGate\": {\n" +
                "            \"conditions\": [\n" +
                "                {\n" +
                "                    \"errorThreshold\": \"1\",\n" +
                "                    \"metric\": \"new_security_rating\",\n" +
                "                    \"onLeakPeriod\": true,\n" +
                "                    \"operator\": \"GREATER_THAN\",\n" +
                "                    \"status\": \"OK\",\n" +
                "                    \"value\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"errorThreshold\": \"1\",\n" +
                "                    \"metric\": \"new_reliability_rating\",\n" +
                "                    \"onLeakPeriod\": true,\n" +
                "                    \"operator\": \"GREATER_THAN\",\n" +
                "                    \"status\": \"OK\",\n" +
                "                    \"value\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"errorThreshold\": \"1\",\n" +
                "                    \"metric\": \"new_maintainability_rating\",\n" +
                "                    \"onLeakPeriod\": true,\n" +
                "                    \"operator\": \"GREATER_THAN\",\n" +
                "                    \"status\": \"OK\",\n" +
                "                    \"value\": \"1\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"errorThreshold\": \"80\",\n" +
                "                    \"metric\": \"new_coverage\",\n" +
                "                    \"onLeakPeriod\": true,\n" +
                "                    \"operator\": \"LESS_THAN\",\n" +
                "                    \"status\": \"NO_VALUE\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"name\": \"SonarQube way\",\n" +
                "            \"status\": \"OK\"\n" +
                "        },\n" +
                "        \"status\": \"SUCCESS\",\n" +
                "        \"taskId\": \"AVh21JS2JepAEhwQ-b3u\"\n" +
                "    }";
        SonarPayload payload = objectMapper.readValue(json.getBytes(Charsets.UTF_8), SonarPayload.class);
        SlackPayload exec = sonarService.exec(payload);
        assertTrue(exec instanceof SlackAttaPayload);

        SlackAttaPayload slack = (SlackAttaPayload) exec;
        assertTrue(StringUtils.isNotBlank(slack.getAttachments().get(0).getText()));
        assertTrue(StringUtils.isNotBlank(slack.getText()));

    }


}