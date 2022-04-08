package com.cen4010.bookstore.author;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthorConfig {

    @Bean
    CommandLineRunner authorCommandLineRunner(AuthorRepository repository){
        return args -> {

        };
    }
}

