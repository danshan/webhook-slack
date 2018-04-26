package com.shanhh.webhook.integration.sonarqube.service;

import com.shanhh.webhook.repo.entity.SlackPayload;
import com.shanhh.webhook.integration.sonarqube.beans.SonarqubePayload;

/**
 * @author dan
 * @since 2017-03-21 17:37
 */
public interface SonarqubeService {
    SlackPayload exec(SonarqubePayload payload);
}
