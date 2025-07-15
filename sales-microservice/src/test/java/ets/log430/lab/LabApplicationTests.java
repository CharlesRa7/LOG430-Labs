package ets.log430.sales;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ets.log430.sales.controllers.HelloController;

@SpringBootTest
class LabApplicationTests {

	@Autowired
	HelloController helloController;

	@Test
	void contextLoads() {	
	}

	@Test
	void returnHelloWorld() {
		assertEquals("Hello, World!", helloController.hello());
	}

}
