package com.career.LucentClothesShop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewsDTO {
	private Integer id;
	private String username;
	private String userImage;
	private String location;
	private Integer rating;
	private String date;
	private String reviewTitle;
	private String reviewVARCHAR;
}
