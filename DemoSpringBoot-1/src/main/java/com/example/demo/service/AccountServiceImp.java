package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Account;
import com.example.demo.responsitories.AccountResposity;

@Service
public class AccountServiceImp implements AccountService{

	@Autowired
	AccountResposity ac;
	
	@Override
	public Optional<Account> findOne(String id) {
		// TODO Auto-generated method stub
		return ac.findById(id);
	}
	
	@Override
	public boolean checkLogin(String username, String password) {
		Optional <Account> optionalUser = ac.findById(username);
		if(optionalUser.isPresent() && optionalUser.get().getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	@Override
	public Iterable<Account> findAll() {
		// TODO Auto-generated method stub
		return ac.findAll();
	}

}
