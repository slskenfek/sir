package com.orders.sir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SirApplication {

	public static void main(String[] args) {
		SpringApplication.run(SirApplication.class, args);
	}

}
