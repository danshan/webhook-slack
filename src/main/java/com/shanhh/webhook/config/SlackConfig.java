package com.shanhh.webhook.config;

import lombok.Getter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author dan
 * @since 2017-03-03 22:43
 */
@Configuration
@Getter
public class SlackConfig {

    @Value("${slack.daocloud}")
    private String slackForDaocloud;

}
