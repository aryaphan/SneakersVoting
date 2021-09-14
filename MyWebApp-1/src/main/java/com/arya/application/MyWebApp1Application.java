package com.arya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.arya.dao.SneakerDAO;


@SpringBootApplication(scanBasePackages = {"com.arya.application", "com.arya.dao", "com.arya.servlet"})
@ServletComponentScan("com.arya.servlet")
@EntityScan("com.arya.model")
public class MyWebApp1Application extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MyWebApp1Application.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MyWebApp1Application.class, args);
		System.out.println("running app");
	}

}