package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class App {

	@RequestMapping("/")
	public String index() {
		return "hello word";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}

}
