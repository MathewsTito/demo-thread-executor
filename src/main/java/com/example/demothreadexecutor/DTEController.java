package com.example.demothreadexecutor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("dtea")
public class DTEController {

    @Autowired
    MyAsyncWorker maw;

    @GetMapping("/{reqId}")
    public Response getBook(@PathVariable int reqId) {
        Response resp = new Response();
        try {

            resp.setReqId(reqId);
            long stime = System.currentTimeMillis();
            Future<Long> result = maw.mywork(reqId, 5000);
            Long l = result.get(5500, TimeUnit.MILLISECONDS);
            long etime = System.currentTimeMillis();
            long tottime = etime - stime;
            resp.setExecutionTime(l.longValue());
            resp.setWaitTime(tottime - l.longValue());
        } catch (Exception e){

        }

        return resp;

    }
}