package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Product;

public interface ProductService {
	
	// load toàn bộ sản phẩm từ db 
	Iterable<Product> findAll();
	
	//lấy product thông qua id 
	Optional<Product> findOne(int id);
	
	void save(Product p);
	
	void delete(int id);
}
