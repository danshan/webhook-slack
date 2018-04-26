package com.shanhh.webhook.integration.docker.service;

import com.shanhh.webhook.integration.docker.beans.DockerPayload;
import com.shanhh.webhook.repo.entity.SlackPayload;

/**
 * @author dan
 * @since 2017-03-13 15:56
 */
public interface DockerService {

    SlackPayload exec(DockerPayload payload);
}
