package com.career.LucentClothesShop.mapper;

import java.util.stream.Collectors;

import com.career.LucentClothesShop.dto.ProductDTO;
import com.career.LucentClothesShop.model.AdditionalImageUrls;
import com.career.LucentClothesShop.model.AvailableSizes;
import com.career.LucentClothesShop.model.Products;

public class ProductMapper {
	public static ProductDTO toDTO(Products product) {
		ProductDTO dto = new ProductDTO();
		dto.setId(product.getId());
        dto.setProductName(product.getProductName());
        dto.setDescription(product.getDescription());
        dto.setIsInStock(product.getIsInStock());
        dto.setGender(product.getGender());
        dto.setCategory(product.getCategory());
        dto.setRating(product.getRating());
        dto.setTotalReviewCount(product.getTotalReviewCount());
        dto.setProductionDate(product.getProductionDate());
        dto.setPrice(product.getPrice());
        dto.setBrandName(product.getBrandName());
        dto.setProductCode(product.getProductCode());
        dto.setImageUrl(product.getImageUrl());
        dto.setAvailableSizes(
        		product.getAvailableSizes()
        		.stream().map(AvailableSizes::getSizes)
        		.collect(Collectors.toList()));
        dto.setAdditionalImageUrls(
        		product.getAdditionalImageUrls()
        		.stream()
        		.map(AdditionalImageUrls::getValue)
        		.collect(Collectors.toList()));
        dto.setReviews(
        		product.getReviews()
        		.stream()
        		.map(ReviewsMapper::toDTO)
        		.collect(Collectors.toList()));
        return dto;
	}
}
