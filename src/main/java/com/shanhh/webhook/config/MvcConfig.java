package com.shanhh.webhook.config;

import com.shanhh.webhook.core.interceptor.PrometheusInterceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

import io.prometheus.client.Collector;
import io.prometheus.client.hotspot.MemoryPoolsExports;
import io.prometheus.client.hotspot.StandardExports;

/**
 * @author dan
 * @since 2017-03-10 15:12
 */
@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public PrometheusInterceptor prometheusInterceptor() {
        return new PrometheusInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(prometheusInterceptor()).addPathPatterns("/**");
    }

    @Bean
    ExporterRegister exporterRegister() {
        List<Collector> collectors = new ArrayList<>();
        collectors.add(new StandardExports());
        collectors.add(new MemoryPoolsExports());
        ExporterRegister register = new ExporterRegister(collectors);
        return register;
    }
}
