package com.example.search.myspringsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient // to be able to register to Eureka naming Server
public class MySpringSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringSearchApplication.class, args);
	}

}
