package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.example.demo.*")
@EnableSwagger2
public class MiddleEarthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiddleEarthApplication.class, args);
	}

}
