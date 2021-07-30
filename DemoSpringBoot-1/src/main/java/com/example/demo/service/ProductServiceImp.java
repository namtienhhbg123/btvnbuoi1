package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.responsitories.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	private ProductRepository pr;
	@Override
	public Iterable<Product> findAll() {
		return pr.findAll();
	}
	@Override
	public Optional<Product> findOne(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}	
	
	@Override
	public void save(Product p) {
		pr.save(p);	
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}
	
	

}
