package com.bit.juniornaver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo.dao")
public class JuniorNaverApplication {

	public static void main(String[] args) {
		SpringApplication.run(JuniorNaverApplication.class, args);
	}

	
	
}
