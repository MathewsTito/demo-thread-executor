package com.example.demothreadexecutor;

import lombok.Data;

@Data
public class Response {
    private int reqId;
    private long executionTime;
    private long waitTime;
}
