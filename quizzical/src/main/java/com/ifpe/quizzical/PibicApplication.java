package com.ifpe.quizzical;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "Quizzical", version = "1", description = "API desenvolvida para desenvolvimento de conhecimento"))
@SpringBootApplication
public class PibicApplication {

	public static void main(String[] args) {
		SpringApplication.run(PibicApplication.class, args);
	}
}
