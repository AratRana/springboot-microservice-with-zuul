package com.arat.ms.integration.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/index")
	public String home() {
		return "index";
	}

	@RequestMapping("/home")
	public String homePage() {
		return "home";
	}

	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
}
