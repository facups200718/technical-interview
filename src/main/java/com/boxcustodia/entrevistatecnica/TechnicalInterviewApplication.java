package com.boxcustodia.entrevistatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TechnicalInterviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(TechnicalInterviewApplication.class, args);
	}

}
