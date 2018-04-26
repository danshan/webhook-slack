package com.shanhh.webhook.service.impl;

import com.google.gson.Gson;
import com.shanhh.webhook.integration.coding.beans.CodingEvent;
import com.shanhh.webhook.integration.coding.beans.CodingPingPayload;
import com.shanhh.webhook.integration.coding.beans.CodingPushPayload;
import com.shanhh.webhook.integration.coding.service.CodingService;
import com.shanhh.webhook.integration.daocloud.beans.DaocloudPayload;
import com.shanhh.webhook.integration.daocloud.service.DaocloudService;
import com.shanhh.webhook.integration.docker.beans.DockerPayload;
import com.shanhh.webhook.integration.docker.service.DockerService;
import com.shanhh.webhook.integration.microbadger.beans.MicrobadgerPayload;
import com.shanhh.webhook.integration.microbadger.service.MicrobadgerService;
import com.shanhh.webhook.integration.sonarqube.beans.SonarqubePayload;
import com.shanhh.webhook.integration.sonarqube.service.SonarqubeService;
import com.shanhh.webhook.repo.entity.Hook;
import com.shanhh.webhook.repo.entity.SlackPayload;
import com.shanhh.webhook.service.SlackService;
import com.shanhh.webhook.service.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shanhonghao
 * @since 2018-04-26 09:20
 */
@Service
@Slf4j
public class WebhookServiceImpl implements WebhookService {

    @Resource
    private DaocloudService daocloudService;
    @Resource
    private MicrobadgerService microbadgerService;
    @Resource
    private DockerService dockerService;
    @Resource
    private SonarqubeService sonarqubeService;
    @Resource
    private CodingService codingService;
    @Resource
    private SlackService slackService;

    private static final Gson gson = new Gson();

    @Override
    public void parseDaocloud(String content) {
        DaocloudPayload daocloudPayload = gson.fromJson(content, DaocloudPayload.class);
        SlackPayload slackPayload = daocloudService.exec(daocloudPayload);
        slackService.send(Hook.daocloud, slackPayload);
    }

    @Override
    public void parseMicrobadger(String content) {
        MicrobadgerPayload microbadgerPayload = gson.fromJson(content, MicrobadgerPayload.class);
        SlackPayload slackPayload = microbadgerService.exec(microbadgerPayload);
        slackService.send(Hook.microbadger, slackPayload);
    }

    @Override
    public void parseDocker(String content) {
        DockerPayload dockerPayload = gson.fromJson(content, DockerPayload.class);
        SlackPayload slackPayload = dockerService.exec(dockerPayload);
        slackService.send(Hook.docker, slackPayload);

    }

    @Override
    public void parseSonarqube(String content) {
        SonarqubePayload sonarqubePayload = gson.fromJson(content, SonarqubePayload.class);
        SlackPayload slackPayload = sonarqubeService.exec(sonarqubePayload);
        slackService.send(Hook.sonarqube, slackPayload);
    }

    @Override
    public void parseCoding(CodingEvent event, String content) {
        SlackPayload slackPayload = null;
        switch (event) {
            case push:
                slackPayload = codingService.exec(gson.fromJson(content, CodingPushPayload.class));
                break;
            case ping:
                slackPayload = codingService.exec(gson.fromJson(content, CodingPingPayload.class));
                break;
            default:
                slackPayload = null;
        }
        slackService.send(Hook.coding, slackPayload);
    }

}
