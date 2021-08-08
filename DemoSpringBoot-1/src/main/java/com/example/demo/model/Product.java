package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



// khai bao cho spring biet day la 1 entity
@Entity
@Table(name = "product")

public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;
	
	
	private String Productname;
	
	
	private float Price;
	
	
	public Product() {
		// TODO Auto-generated constructor stub
	}


	public Product(int iD, String productname) {
		super();
		ID = iD;
		Productname = productname;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getProductname() {
		return Productname;
	}


	public void setProductname(String productname) {
		Productname = productname;
	}


	public float getPrice() {
		return Price;
	}


	public void setPrice(float price) {
		Price = price;
	}


	

	

	
	
	
	
}
