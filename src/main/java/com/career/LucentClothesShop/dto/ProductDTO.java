package com.career.LucentClothesShop.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	private Integer id;
    private String productName;
    private String description;
    private Boolean isInStock;
    private String gender;
    private String category;
    private Integer rating;
    private Integer totalReviewCount;
    private String productionDate;
    private Double price;
    private String brandName;
    private Long productCode;
    private String imageUrl;
    private List<String> availableSizes;
    private List<String> additionalImageUrls;
    private List<ReviewsDTO> reviews;
}
