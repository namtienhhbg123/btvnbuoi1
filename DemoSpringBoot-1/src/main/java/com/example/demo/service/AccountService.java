package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.model.Product;

public interface AccountService {

	Optional<Account> findOne(String id);
		
	Iterable<Account> findAll();
	
	Optional<Account> findUser(String userName , String password);
	
	
}
