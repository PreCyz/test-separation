package com.gawa.integration;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Category(IntegrationTest.class)
public class IntegrationApplicationTests {

	@Autowired
	private Environment environment;

	@Test
	public void contextLoads() {
		assertThat(environment.getProperty("application.mode")).isEqualTo("integration");
	}

}
