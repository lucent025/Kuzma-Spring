package com.career.LucentClothesShop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor	
public class ProductFilter {
	private String brand;
	private String category;
	private String date;
	private String gender;
	private String order;
	private Double price;
	private String search;
	private Boolean isInStock;
}
