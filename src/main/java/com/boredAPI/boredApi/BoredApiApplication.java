package com.boredAPI.boredApi;

import com.boredAPI.boredApi.Client.BoredClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@SpringBootApplication
public class BoredApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoredApiApplication.class, args);
	}


	@Bean
	BoredClient boredClient(){
		WebClient client = WebClient.builder()
				.baseUrl("https://www.boredapi.com/api")
				.defaultHeader("Accept", "application/json")
				.build();

		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builder(WebClientAdapter.forClient(client))
				.build();
		return factory.createClient(BoredClient.class);
	}

}
