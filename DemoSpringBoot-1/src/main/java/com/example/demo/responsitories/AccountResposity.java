package com.example.demo.responsitories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public interface AccountResposity extends CrudRepository<Account, String>{
		
}
