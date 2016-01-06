package com.test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Default {

	@RequestMapping("/")
	public String index() {
		return "hello word";
	}
}
