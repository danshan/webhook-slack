package com.shanhh.webhook.docker.service;

import com.shanhh.webhook.docker.beans.DockerPayload;
import com.shanhh.webhook.slack.beans.SlackPayload;

/**
 * @author dan
 * @since 2017-03-13 15:56
 */
public interface DockerService {

    SlackPayload exec(DockerPayload payload);
}
