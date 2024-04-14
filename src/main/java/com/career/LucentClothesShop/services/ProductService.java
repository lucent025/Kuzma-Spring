package com.career.LucentClothesShop.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	
	public List<ProductDTO> getProductsByBrand(String brandName) {
		Products productBrandName = new Products();
		productBrandName.setBrandName(brandName);
        Example<Products> example = Example.of(productBrandName);
        List<Products> products = productRepository.findAll(example);
		return products
				.stream()
				.map(ProductMapper::toDTO)
				.collect(Collectors.toList());
	}
}
