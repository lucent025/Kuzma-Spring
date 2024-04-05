package com.career.LucentClothesShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.LucentClothesShop.model.Products;
import com.career.LucentClothesShop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<Products> allProducts() {
		return productRepository.findAll();
	}
}
