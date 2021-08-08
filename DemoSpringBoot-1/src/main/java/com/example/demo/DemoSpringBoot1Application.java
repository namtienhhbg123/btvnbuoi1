package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Account;
import com.example.demo.responsitories.AccountResposity;


@SpringBootApplication
public class DemoSpringBoot1Application {
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBoot1Application.class, args);
		
	}
	
	

}
