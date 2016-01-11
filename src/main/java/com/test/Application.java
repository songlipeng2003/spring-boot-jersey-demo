package com.test;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application extends ResourceConfig {

	public Application() {
		packages("com.test").register(LoggingFilter.class);
	}
}