package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class FirstApplication extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FirstApplication.class);
	}

	@Override
	public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {

	}

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class,args);
	}
}
