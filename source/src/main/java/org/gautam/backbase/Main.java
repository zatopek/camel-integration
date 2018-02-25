package org.gautam.backbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("org.gautam.backbase.routers")
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
