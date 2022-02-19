package com.cen4010.bookstore.wishlist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WishListConfig {

  @Bean
  CommandLineRunner commandLineRunner() {
    return args -> {
    };
  }
}
