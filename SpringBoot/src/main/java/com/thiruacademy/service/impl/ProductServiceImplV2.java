package com.thiruacademy.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.thiruacademy.entity.Product;
import com.thiruacademy.exception.ProductNotFoundException;
import com.thiruacademy.service.ProductService;

@Service
public class ProductServiceImplV2 implements ProductService {

	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> fetchAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product fetchProduct(Long id) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product putUpdateProduct(Long id, Product product) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product patchUpdateProduct(Long id, Map<String, Object> productMap) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
