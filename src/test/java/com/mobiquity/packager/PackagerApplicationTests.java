package com.mobiquity.packager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@SpringBootApplication
@ComponentScan("com.mobiquity.packager")
class PackagerApplicationTests {

	@Test
	void contextLoads() {
	}

}
