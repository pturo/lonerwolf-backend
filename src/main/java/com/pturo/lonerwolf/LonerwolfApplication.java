package com.pturo.lonerwolf;

import com.pturo.lonerwolf.config.SwaggerConfiguration;
import com.pturo.lonerwolf.exceptions.LonerWolfException;
import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = "com.pturo.lonerwolf.model")
@EnableAsync
@Import(SwaggerConfiguration.class)
public class LonerwolfApplication {

	private static ConfigurableApplicationContext configurableApplicationContext;

	public static void main(String[] args) {
		LonerwolfApplication.configurableApplicationContext = SpringApplication.run(LonerwolfApplication.class, args);
	}

}
