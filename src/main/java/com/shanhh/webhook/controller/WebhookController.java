package com.shanhh.webhook.controller;

import org.apache.http.client.HttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import javax.annotation.Resource;

/**
 * @author dan
 * @since 2017-03-03 16:29
 */
@RestController
@RequestMapping("/webhook")
public class WebhookController {

    @Resource
    private HttpClient httpClient;

    @RequestMapping(value = "daocloud", method = RequestMethod.POST)
    public String daocloud() throws IOException {
        return "";
    }

}
