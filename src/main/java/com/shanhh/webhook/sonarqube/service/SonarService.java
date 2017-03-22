package com.shanhh.webhook.sonarqube.service;

import com.shanhh.webhook.slack.beans.SlackPayload;
import com.shanhh.webhook.sonarqube.beans.SonarPayload;

/**
 * @author dan
 * @since 2017-03-21 17:37
 */
public interface SonarService {
    SlackPayload exec(SonarPayload payload);
}
