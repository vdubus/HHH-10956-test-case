package com.github.vdubus.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author vdubus
 */
@SpringBootApplication
@EnableTransactionManagement
public class Application {

	public static void main(final String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
