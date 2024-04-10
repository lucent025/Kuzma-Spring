package com.career.LucentClothesShop.model;

import java.util.List;

import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Products {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "isInStock")
	private Boolean isInStock;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "totalReviewCount")
	private Integer totalReviewCount;
	
	@Column(name = "productionDate")
	private String productionDate;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "brandName")
	private String brandName;
	
	@Column(name = "productCode")
	private Long productCode;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<AvailableSizes> availableSizes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<AdditionalImageUrls> additionalImageUrls;
}
