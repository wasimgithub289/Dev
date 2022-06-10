package com.ng.services;

import java.util.Optional;
import com.ng.entities.Product;

public interface ProductService 
{
	public Iterable<Product> findAll();

	public Product saveProduct(Product product);
	
	public Optional<Product> getProduct(int id);
}