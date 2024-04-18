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
import com.career.LucentClothesShop.model.ProductFilter;
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
		return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
	}

	public List<ProductDTO> getProductsByCategory(String category) {
		Products productCategory = new Products();
		productCategory.setCategory(category);
		Example<Products> example = Example.of(productCategory);
		List<Products> products = productRepository.findAll(example);
		return products.stream().map(ProductMapper::toDTO).collect(Collectors.toList());
	}

	public Page<ProductDTO> getProductByKeyWord(String key, Pageable page) {
		Page<Products> products = productRepository.findProductByKeyWord(key, page);
		return products.map(ProductMapper::toDTO);
	}

	public Page<ProductDTO> getProductByFilter(ProductFilter filter, Pageable page) {
		Page<Products> products = productRepository.findByFilter(filter.getBrand(), filter.getCategory(),
				filter.getDate(), filter.getGender(), filter.getOrder(), filter.getPrice(), filter.getSearch(),
				filter.getIsInStock(), page);
		return products.map(ProductMapper::toDTO);
	}
}
