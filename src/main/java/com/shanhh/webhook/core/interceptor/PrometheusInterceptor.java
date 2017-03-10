package com.shanhh.webhook.core.interceptor;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.prometheus.client.Counter;

/**
 * @author dan
 * @since 2017-03-10 15:15
 */
@NoArgsConstructor
@Slf4j
@Component
public class PrometheusInterceptor extends HandlerInterceptorAdapter {

    static final Counter requestCnt = Counter.build().name("requests_total").help("Total requests.").register();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        requestCnt.inc();
        return true;
    }
}
