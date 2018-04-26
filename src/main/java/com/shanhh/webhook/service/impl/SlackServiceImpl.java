package com.shanhh.webhook.service.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shanhh.webhook.repo.client.SlackClient;
import com.shanhh.webhook.repo.entity.Hook;
import com.shanhh.webhook.repo.entity.SlackPayload;
import com.shanhh.webhook.service.SlackService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author dan
 * @since 2017-03-03 22:40
 */
@Service
@Slf4j
public class SlackServiceImpl implements SlackService {

    @Resource
    private ApplicationContext context;

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String send(Hook hook, SlackPayload slackPayload) {
        if (slackPayload == null) {
            return "payload is empty";
        }

        String payload = gson.toJson(slackPayload);
        log.info("slack payload: \n{}", payload);
        return getHookClient(hook).send(payload);
    }

    private SlackClient getHookClient(Hook hook) {
        return context.getBean(hook.name() + "Client", SlackClient.class);
    }
}
