package com.shanhh.webhook.slack.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shanhh.webhook.config.SlackConfig;
import com.shanhh.webhook.slack.beans.Hook;
import com.shanhh.webhook.slack.beans.SlackPayload;

import lombok.extern.slf4j.Slf4j;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.annotation.Resource;

/**
 * @author dan
 * @since 2017-03-03 22:40
 */
@Service
@Slf4j
public class SlackServiceImpl implements SlackService {

    @Resource
    private HttpClient httpClient;
    @Resource
    private SlackConfig slackConfig;
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public String send(Hook hook, SlackPayload payload) {
        if (payload == null) {
            return "skip";
        }
        HttpPost request = new HttpPost(getHookUrl(hook));
        request.addHeader("Content-Type", "application/json");

        try {
            request.setEntity(new StringEntity(objectMapper.writeValueAsString(payload)));
            HttpResponse response = httpClient.execute(request);
            String result = EntityUtils.toString(response.getEntity(), Charset.defaultCharset());
            return result;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    private String getHookUrl(Hook hook) {
        switch (hook) {
            case DAOCLOUD:
                return slackConfig.getSlackForDaocloud();
            case MICROBADGER:
                return slackConfig.getSlackForMicrobadger();
            case DOCKER:
                return slackConfig.getSlackForDocker();
            case SONAR:
                return slackConfig.getSonarForDocker();
            default:
                throw new IllegalArgumentException("unsupported webhook");
        }
    }
}
