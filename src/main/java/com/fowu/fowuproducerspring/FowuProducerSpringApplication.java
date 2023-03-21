package com.fowu.fowuproducerspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FowuProducerSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(FowuProducerSpringApplication.class, args);
    }

}
