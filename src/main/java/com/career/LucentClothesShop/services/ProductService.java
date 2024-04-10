package com.career.LucentClothesShop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.LucentClothesShop.dto.ProductDTO;
import com.career.LucentClothesShop.mapper.ProductMapper;
import com.career.LucentClothesShop.model.Products;
import com.career.LucentClothesShop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductDTO> allProducts() {
		List<Products> products = productRepository.findAll();
		return products.stream()
                .map(ProductMapper::toDTO)
                .collect(Collectors.toList());
	}
}
