package com.example.demo;

import com.example.demo.controller.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	HomeController homeController;
	@Test
	void contextLoads() throws  Exception{
		System.out.println("sans");
		assertThat(homeController).isNull();
	}

}
