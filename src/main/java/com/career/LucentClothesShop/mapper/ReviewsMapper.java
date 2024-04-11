package com.career.LucentClothesShop.mapper;

import com.career.LucentClothesShop.dto.ReviewsDTO;
import com.career.LucentClothesShop.model.Reviews;

public class ReviewsMapper {
	public static ReviewsDTO toDTO(Reviews reviews) {
		ReviewsDTO dto = new ReviewsDTO();
		dto.setId(reviews.getId());
		dto.setUsername(reviews.getUsername());
		dto.setUserImage(reviews.getUserImage());
		dto.setLocation(reviews.getLocation());
		dto.setRating(reviews.getRating());
		dto.setDate(reviews.getDate());
		dto.setReviewTitle(reviews.getReviewTitle());
		dto.setReviewVARCHAR(reviews.getReviewVARCHAR());
		return dto;
	}
}
