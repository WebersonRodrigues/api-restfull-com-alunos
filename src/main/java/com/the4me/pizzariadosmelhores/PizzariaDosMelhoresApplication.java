package com.the4me.pizzariadosmelhores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PizzariaDosMelhoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzariaDosMelhoresApplication.class, args);
	}

}
