package com.shanhh.webhook.controller;

import com.shanhh.webhook.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.daocloud.service.DaocloudService;
import com.shanhh.webhook.docker.beans.DockerPayload;
import com.shanhh.webhook.docker.service.DockerService;
import com.shanhh.webhook.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.microbadger.service.MicrobadgerService;
import com.shanhh.webhook.slack.beans.Hook;
import com.shanhh.webhook.slack.beans.SlackPayload;
import com.shanhh.webhook.slack.service.SlackService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.annotation.Resource;

/**
 * @author dan
 * @since 2017-03-03 16:29
 */
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Resource
    private DaocloudService daocloudService;
    @Resource
    private MicrobadgerService microbadgerService;
    @Resource
    private DockerService dockerService;
    @Resource
    private SlackService slackService;

    @RequestMapping(value = "daocloud", method = RequestMethod.POST)
    public String daocloud(@RequestBody DaocloudPayload payload) throws IOException {
        SlackPayload slackPayload = daocloudService.exec(payload);
        return slackService.send(Hook.DAOCLOUD, slackPayload);
    }

    @RequestMapping(value = "microbadger", method = RequestMethod.POST)
    public String daocloud(@RequestBody MicrobadgerPayload payload) throws IOException {
        SlackPayload slackPayload = microbadgerService.exec(payload);
        return slackService.send(Hook.MICROBADGER, slackPayload);
    }

    @RequestMapping(value = "docker", method = RequestMethod.POST)
    public String daocloud(@RequestBody DockerPayload payload) throws IOException {
        SlackPayload slackPayload = dockerService.exec(payload);
        return slackService.send(Hook.DOCKER, slackPayload);
    }

}
