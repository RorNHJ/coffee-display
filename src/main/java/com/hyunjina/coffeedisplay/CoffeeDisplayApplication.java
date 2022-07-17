package com.hyunjina.coffeedisplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class CoffeeDisplayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeDisplayApplication.class, args);
	}

}
