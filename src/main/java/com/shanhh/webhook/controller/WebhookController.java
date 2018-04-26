package com.shanhh.webhook.controller;

import com.shanhh.webhook.integration.coding.beans.CodingEvent;
import com.shanhh.webhook.service.WebhookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dan
 * @since 2017-03-03 16:29
 */
@RestController
@RequestMapping("/webhook")
@Slf4j
public class WebhookController {

    @Resource
    private WebhookService webhookService;

    @RequestMapping(value = "daocloud", method = RequestMethod.POST)
    public void parseDaocloud(@RequestBody String content) {
        log.info("daocloud request: {}", content);
        webhookService.parseDaocloud(content);
    }

    @RequestMapping(value = "microbadger", method = RequestMethod.POST)
    public void parseMicrobadger(@RequestBody String content) {
        log.info("microbadger request: {}", content);
        webhookService.parseMicrobadger(content);
    }

    @RequestMapping(value = "docker", method = RequestMethod.POST)
    public void parseDocker(@RequestBody String content) {
        log.info("docker request: {}", content);
        webhookService.parseDocker(content);
    }

    @RequestMapping(value = "sonarqube", method = RequestMethod.POST)
    public void parseSonarqube(@RequestBody String content) {
        log.info("sonarqube request: {}", content);
        webhookService.parseSonarqube(content);
    }

    @RequestMapping(value = "coding", method = RequestMethod.POST)
    public void parseCoding(
            @RequestHeader("X-Coding-Event") CodingEvent event,
            @RequestBody String content
    ) {
        log.info("coding request {}: {}", event, content);
        webhookService.parseCoding(event, content);
    }

    @RequestMapping(value = "debug", method = RequestMethod.POST)
    public void debug(@RequestBody String content) {
        log.info("debug request: {}", content);
    }
}
