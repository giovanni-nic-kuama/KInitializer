package com.kuama.kinitializer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
public class KInitializerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KInitializerApplication.class, args);
	}

}
