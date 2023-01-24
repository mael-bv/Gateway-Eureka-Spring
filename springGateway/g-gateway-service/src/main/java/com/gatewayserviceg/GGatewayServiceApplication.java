package com.gatewayserviceg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.netflix.discovery.DiscoveryClient;

@SpringBootApplication
public class GGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GGatewayServiceApplication.class, args);
	}
	
	//@Bean
	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
			return builder.routes()
					.route(r->r.path("/customers/**").uri("lb://CUSTOMERS-SERVICE"))
					.route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
					.build();
	}
	
	@Bean
	DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
		return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
	}
	
	

}
