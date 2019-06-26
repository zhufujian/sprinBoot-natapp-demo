package com.stduy.springBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
//@EnableScheduling
@EnableSwagger2
@EnableAsync //开启异步调用
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
