package com.example.demothreadexecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DemoThreadExecutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoThreadExecutorApplication.class, args);
	}

}
