package com.example.demothreadexecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@org.springframework.context.annotation.Configuration
public class Configuration {

    private static Logger LOG = LoggerFactory.getLogger(Configuration.class);

    @Bean("cachedThreadPool")
    public ExecutorService cachedThreadPool() {
        LOG.info("Creating Executor Threadpool");
        return Executors.newCachedThreadPool();
    }

    @Bean("blockingThreadPool")
    public ExecutorService blockingThreadPool() {
        LOG.info("Creating Executor Threadpool");
        ExecutorService es = new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(2));

        return es;
    }

    @Bean("syncThreadPool")
    public ExecutorService syncThreadPool() {
        LOG.info("Creating Executor Threadpool");
        ExecutorService es = new ThreadPoolExecutor(2,2,1, TimeUnit.SECONDS,new SynchronousQueue<Runnable>());

        return es;
    }

    @Bean("springThreadPool")
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(5);
        executor.setQueueCapacity(0);
        executor.setThreadNamePrefix("springThreadPool-");
        executor.initialize();
        return executor;
    }

}
