package com.career.LucentClothesShop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.career.LucentClothesShop.dto.ProductDTO;
import com.career.LucentClothesShop.mapper.ProductMapper;
import com.career.LucentClothesShop.model.Products;
import com.career.LucentClothesShop.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;
	
	public Page<ProductDTO> getLimitedProducts(Pageable pageable) {
		Page<Products> products = productRepository.findAll(pageable);
		return products.map(ProductMapper::toDTO);
	}
	
	public Optional<ProductDTO> getSingleProduct(int id) {
		Optional<Products> product = productRepository.findById(id);
		return product.map(ProductMapper::toDTO);
	}
}
