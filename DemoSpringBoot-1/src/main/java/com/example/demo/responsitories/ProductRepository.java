package com.example.demo.responsitories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Product;


// tao ProductRepository  là đẻ dùng CrudRepository thông qua ProductRepository
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer>{
	
		//Iterable<Product> findAll();
		
		
}
