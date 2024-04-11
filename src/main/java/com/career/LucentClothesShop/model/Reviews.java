package com.career.LucentClothesShop.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reviews {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "userImage")
	private String userImage;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "reviewTitle")
	private String reviewTitle;
	
	@Column(name = "reviewVARCHAR")
	private String reviewVARCHAR;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_id")
    private Products product;
}
