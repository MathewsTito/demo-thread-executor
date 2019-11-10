package com.example.demothreadexecutor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;


@Component
public class MyAsyncWorker {

    @Async("springThreadPool")
    public Future<Long> mywork(int reqId, long execTime){
        long stime = System.currentTimeMillis();

        try {
            Thread.sleep(execTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long etime = System.currentTimeMillis();

        return new AsyncResult<Long>(etime-stime);
    }
}
