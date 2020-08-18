package com.arya.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.arya.dao.SneakerDAO;

@SpringBootApplication(scanBasePackages = {"com.arya.application", "com.arya.dao"})
public class MyWebApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(MyWebApp1Application.class, args);
		System.out.println("running app");
	}

}
