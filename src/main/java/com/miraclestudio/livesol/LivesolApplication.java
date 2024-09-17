package com.miraclestudio.livesol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@PropertySource("classpath:/env.yml")
public class LivesolApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivesolApplication.class, args);
	}

}
