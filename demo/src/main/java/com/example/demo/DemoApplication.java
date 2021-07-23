package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

///@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication()
public class DemoApplication {
	//Sorry it was PS2 all the time haha
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
