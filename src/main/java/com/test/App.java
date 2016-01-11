package com.test;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class App extends SpringBootServletInitializer {

	// public static void main(String[] args) throws Exception {
	// SpringApplication.run(new Class[] { Application.class,
	// ApplicationInitializer.class }, args);
	// }

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args) {
		new App().configure(new SpringApplicationBuilder(App.class)).run(args);
	}
}
