package com.shanhh.webhook.repo.client;

import feign.Headers;
import feign.RequestLine;
import org.springframework.http.MediaType;

/**
 * @author shanhonghao
 * @since 2018-04-26 09:25
 */
public interface SlackClient {

    @RequestLine("POST")
    @Headers("Content-Type: " + MediaType.APPLICATION_JSON_UTF8_VALUE)
    String send(String payload);

}
