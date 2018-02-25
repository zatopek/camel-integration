package org.gautam.backbase.integration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.integration.config.EnableIntegration;

/**
 * Barebones spring boot application config
 * 
 * @author zatopek
 *
 */

@SpringBootApplication
@EnableIntegration
@ComponentScan("org.gautam.backbase.integration.config")
public class Main {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}
