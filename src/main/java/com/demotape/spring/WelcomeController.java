package com.demotape.spring;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application welcome page.
 */
@Controller
@RequestMapping("/welcome")
public class WelcomeController {

	private Logger logger = org.slf4j.LoggerFactory.getLogger(WelcomeController.class);

	/**
	 * Simply selects the welcome view to render by returning void and relying
	 * on the default request-to-view-translator.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public void welcome() {
		logger.info("Welcome!");
	}
}
