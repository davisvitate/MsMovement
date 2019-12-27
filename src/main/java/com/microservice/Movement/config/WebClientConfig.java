package com.microservice.Movement.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class WebClientConfig {

	@Bean
	@Qualifier("Movement")
	public WebClient registerWebClient() {
		return WebClient.create("");
		
	}
}
