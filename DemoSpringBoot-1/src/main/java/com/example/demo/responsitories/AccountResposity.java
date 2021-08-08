package com.example.demo.responsitories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Account;

@Repository
public interface AccountResposity extends CrudRepository<Account, String>{	
	
	  @Query(value = "SELECT * FROM demospring.user where UserName = ?1 and Password = ?2", nativeQuery = true)
	  public Optional<Account> findUser(String userName,  String password);
	  
}
