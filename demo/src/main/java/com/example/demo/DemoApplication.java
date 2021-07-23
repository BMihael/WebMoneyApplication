package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

///@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@SpringBootApplication()
public class DemoApplication {
	//Its actually PS4
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
