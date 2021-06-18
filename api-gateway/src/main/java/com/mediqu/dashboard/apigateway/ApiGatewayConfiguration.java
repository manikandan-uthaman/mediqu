package com.mediqu.dashboard.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/patients/**").uri("lb://patient-service"))
				.route(p -> p.path("/doctors/**").uri("lb://doctor-service"))
				.route(p -> p.path("/staffs/**").uri("lb://staff-service"))
				.route(p -> p.path("/general/**").uri("lb://general-service"))
				.route(p -> p.path("/appointments/**").uri("lb://appointment-service"))
				.route(p -> p.path("/notifications/**").uri("lb://notification-service"))
				.route(p -> p.path("/reviews/**").uri("lb://review-service"))
				.build();
	}
}
