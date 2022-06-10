package com.ng.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ng.entities.Product;
import com.ng.repositories.ProductRepository;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService 
{
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findAll() 
	{
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) 
	{
		return productRepository.save(product);
	}

	@Override
	public Optional<Product> getProduct(int id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id);
	}

}