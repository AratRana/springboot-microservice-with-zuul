package com.arat.webworks.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RolesUIController {

	@RequestMapping("/")
	public String getAllRoles(Model model) {
		return "rolespage";
	}
	
	
}
