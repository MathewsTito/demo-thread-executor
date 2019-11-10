package com.example.demothreadexecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static Logger LOG = LoggerFactory.getLogger(Configuration.class);

    @Bean("cachedThreadPool")
    public ExecutorService cachedThreadPool() {
        LOG.info("Creating Executor Threadpool");
        return Executors.newCachedThreadPool();
    }

}
