package org.gautam.backbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * A trivial configuration class for this project
 * 
 * @author Gautam Velpula
 *
 */

@SpringBootApplication
@ComponentScan({ "org.gautam.backbase.routers", "org.gautam.backbase.translator" })
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
}
