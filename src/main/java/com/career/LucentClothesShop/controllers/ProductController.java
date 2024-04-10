package com.career.LucentClothesShop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.LucentClothesShop.dto.ProductDTO;
import com.career.LucentClothesShop.services.ProductService;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> getAllProducts() {
		return new ResponseEntity<List<ProductDTO>>(service.allProducts(), HttpStatus.OK);
	}
}
