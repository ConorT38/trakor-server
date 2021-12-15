package com.trakor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TrakorApplication {

	/**
	 * Entry point of Trakor.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(TrakorApplication.class, args);
	}

}
