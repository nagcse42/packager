package com.mobiquity.packager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mobiquity.packager")
public class PackagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PackagerApplication.class, args);
	}

}
