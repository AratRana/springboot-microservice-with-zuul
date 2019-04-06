package com.arat.security.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterpriseServiceUIController {

	@RequestMapping("/")
	public String home() {
		return "enterprise";
	}
}
