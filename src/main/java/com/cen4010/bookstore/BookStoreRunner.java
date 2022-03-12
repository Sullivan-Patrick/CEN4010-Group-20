package com.cen4010.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the entry point of the application.
 */
@SpringBootApplication
@RestController
public class BookStoreRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreRunner.class, args);
	}

	@GetMapping
	public static String hello(){
		return "Welcome to Geek Text!";
	}

}
