package com.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScan({ "com.controller", "com.service","com.error"})
@EnableJpaRepositories("com.repos")
@EntityScan({ "com.model" })
@EnableTransactionManagement
public class CgRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgRestApplication.class, args);
	}

}
