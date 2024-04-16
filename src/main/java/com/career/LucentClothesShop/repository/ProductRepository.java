package com.career.LucentClothesShop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.career.LucentClothesShop.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	@Query(value = "SELECT o FROM Products o WHERE o.productName LIKE %:key% OR o.gender LIKE :key OR o.category LIKE :key OR o.brandName LIKE :key")
	Page<Products> findProductByKeyWord(String key, Pageable page);
}
