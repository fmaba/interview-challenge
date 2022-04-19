package com.example.volvo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class VolvoApplication {

    public static void main(String[] args) {
        SpringApplication.run(VolvoApplication.class, args);
    }

}
