package com.demotape.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value="/secure_page", method = RequestMethod.GET)
	public String securePage(Model model) {		
		return "admin/secure_page";		
	}
	
	@RequestMapping(value="/very_secure_page", method = RequestMethod.GET)
	public String verySecurePage(Model model) {		
		return "admin/very_secure_page";		
	}
}
