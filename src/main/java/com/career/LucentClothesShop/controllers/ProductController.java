package com.career.LucentClothesShop.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.career.LucentClothesShop.dto.ProductDTO;
import com.career.LucentClothesShop.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping("/landing")
	public ResponseEntity<Page<ProductDTO>> getAllProducts(@RequestParam int page, @RequestParam int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return new ResponseEntity<Page<ProductDTO>>(service.getLimitedProducts(pageable), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<ProductDTO>> getSingleProduct(@PathVariable int id) {
		return new ResponseEntity<Optional<ProductDTO>>(service.getSingleProduct(id), HttpStatus.OK);
	}
	
	@GetMapping("/brand/{brandName}")
	public ResponseEntity<List<ProductDTO>> getProductsByBrandName(@PathVariable String brandName) {
		return new ResponseEntity<List<ProductDTO>>(service.getProductsByBrand(brandName), HttpStatus.OK);
	}
	
	@GetMapping("/category/{category}")
	public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable String category) {
		return new ResponseEntity<List<ProductDTO>>(service.getProductsByCategory(category), HttpStatus.OK);
	}
	
	@GetMapping("/search")
	public ResponseEntity<Page<ProductDTO>> getProductByKeyWord(@RequestParam String key ,@RequestParam int page, @RequestParam int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		return new ResponseEntity<Page<ProductDTO>>(service.getProductByKeyWord(key, pageable), HttpStatus.OK);
	}
}
