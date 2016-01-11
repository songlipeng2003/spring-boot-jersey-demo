package com.test;

import io.swagger.jaxrs.config.BeanConfig;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Application extends ResourceConfig {

	public Application() {
		packages(new String[] { "io.swagger.jaxrs.listing", "com.test" })
				.register(LoggingFilter.class);

		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setTitle("Spring Jersey Swagger API demo");
		beanConfig.setDescription("api description");
		beanConfig.setTermsOfServiceUrl("http://swagger.io/terms/");
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8002");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("com.test.jersey");
		beanConfig.setScan(true);
	}
}