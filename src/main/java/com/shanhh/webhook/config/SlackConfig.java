package com.shanhh.webhook.config;

import com.shanhh.webhook.repo.client.SlackClient;
import feign.Feign;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dan
 * @since 2017-03-03 22:43
 */
@Configuration
@Getter
@Setter
public class SlackConfig {

    @Value("${slack.daocloud:}")
    private String daocloud;

    @Value("${slack.microbadger:}")
    private String microbadger;

    @Value("${slack.docker:}")
    private String docker;

    @Value("${slack.sonarqube:}")
    private String sonarqube;

    @Value("${slack.coding:}")
    private String coding;

    @Bean("daocloudClient")
    @ConditionalOnProperty("slack.daocloud")
    public SlackClient daocloudClient() {
        return Feign.builder().target(SlackClient.class, this.daocloud);
    }

    @Bean("microbadgerClient")
    @ConditionalOnProperty("slack.microbadger")
    public SlackClient microbadgerClient() {
        return Feign.builder().target(SlackClient.class, this.microbadger);
    }

    @Bean("dockerClient")
    @ConditionalOnProperty("slack.docker")
    public SlackClient dockerClient() {
        return Feign.builder().target(SlackClient.class, this.docker);
    }

    @Bean("sonarqubeClient")
    @ConditionalOnProperty("slack.sonarqube")
    public SlackClient sonarqubeClient() {
        return Feign.builder().target(SlackClient.class, this.sonarqube);
    }

    @Bean("codingClient")
    @ConditionalOnProperty("slack.coding")
    public SlackClient coingClient() {
        return Feign.builder().target(SlackClient.class, this.coding);
    }
    
}
