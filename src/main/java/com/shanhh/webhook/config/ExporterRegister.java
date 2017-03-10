package com.shanhh.webhook.config;

import lombok.Getter;

import java.util.List;

import io.prometheus.client.Collector;

/**
 * @author dan
 * @since 2017-03-10 15:40
 */
public class ExporterRegister {

    @Getter
    private List<Collector> collectors;

    public ExporterRegister(List<Collector> collectors) {
        for (Collector collector : collectors) {
            collector.register();
        }
        this.collectors = collectors;
    }

}
