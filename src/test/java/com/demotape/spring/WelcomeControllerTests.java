package com.demotape.spring;

import org.junit.Test;

public class WelcomeControllerTests {
	
	private WelcomeController controller = new WelcomeController();
	
	@Test
	public void welcome() {
		controller.welcome();
	}
	
}
