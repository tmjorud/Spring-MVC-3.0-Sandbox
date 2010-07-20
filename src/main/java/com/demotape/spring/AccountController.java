package com.demotape.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/account")
public class AccountController {

	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(Model model) {		
		return "account/login";		
	}
	
	@RequestMapping(value="/accessDenied", method = RequestMethod.GET)
	public String accessDenied(Model model) {		
		return "account/accessDenied";	
	}
}
