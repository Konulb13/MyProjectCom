package com.example.konul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KonulApplication {

	public static void main(String[] args) {
		SpringApplication.run(KonulApplication.class, args);
	}

}
