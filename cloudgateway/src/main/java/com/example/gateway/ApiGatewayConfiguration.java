package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
	
	@Bean
	public RouteLocator getwayRourter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/get")
						.filters(f -> f
								.addRequestHeader("header1", "praveen")
								.addRequestHeader("header2", "kumar")
								.addRequestParameter("Param1", "Hyderabad")
								.addRequestParameter("Param2", "Chennai"))
						.uri("http://httpbin.org:80"))
				
				.route(p -> p
						.path("/post")
						.filters(f -> f
								.addRequestHeader("header10", "myheader10")
								.addRequestParameter("param10", "Chennai10"))
						.uri("http://httpbin.org:80"))
						
				.route(p->p.path("/notes/**").uri("lb://NOTE-SERVICE/notes"))
				.route(p->p.path("/comments/**").uri("lb://COMMENT-SERVICE/comments"))
				.build();
	}
}
