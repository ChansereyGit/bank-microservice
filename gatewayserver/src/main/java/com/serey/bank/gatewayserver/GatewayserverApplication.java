package com.serey.bank.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/sereybank/account/**")
						.filters(f -> f.rewritePath("/sereybank/account/(?<segment>.*)","/${segment}")

								.addResponseHeader("X-RESPONSE-TIME", LocalDateTime.now().toString()))

						.uri("lb://ACCOUNT")).
				route(p -> p
						.path("/sereybank/loan/**")
						.filters(f -> f.rewritePath("/sereybank/loan/(?<segment>.*)","/${segment}"))

						.uri("lb://LOAN")).
				route(p -> p
						.path("/sereybank/card/**")
						.filters(f -> f.rewritePath("/sereybank/card/(?<segment>.*)","/${segment}"))

						.uri("lb://CARD")).build();
	}
}
