package com.shanhh.webhook.service;

import com.shanhh.webhook.integration.coding.beans.CodingEvent;

/**
 * @author shanhonghao
 * @since 2018-04-26 09:12
 */
public interface WebhookService {

    void parseDaocloud(String content);

    void parseMicrobadger(String content);

    void parseDocker(String content);

    void parseSonarqube(String content);

    void parseCoding(CodingEvent event, String content);
}
