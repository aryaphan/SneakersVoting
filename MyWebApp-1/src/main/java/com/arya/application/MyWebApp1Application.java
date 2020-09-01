package com.arya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.arya.dao.SneakerDAO;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = {"com.arya.application", "com.arya.dao", "com.arya.servlet"})
public class MyWebApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApp1Application.class, args);
		System.out.println("running app");
	}

}
