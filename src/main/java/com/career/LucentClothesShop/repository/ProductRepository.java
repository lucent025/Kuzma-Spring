package com.career.LucentClothesShop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.career.LucentClothesShop.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {
	@Query(value = "SELECT o FROM Products o WHERE o.gender LIKE :key OR o.category LIKE :key OR o.brandName LIKE :key OR o.productName LIKE %:key%")
	Page<Products> findProductByKeyWord(String key, Pageable page);
	
	@Query(value = "SELECT o FROM Products o WHERE "
			+ "(:brand IS NULL OR o.brandName = :brand) "
			+ "AND (:category IS NULL OR o.category = :category) "
			+ "AND (:date IS NULL OR o.productionDate = :date) "
			+ "AND (:gender IS NULL OR o.gender = :gender) "
			+ "AND (:price IS NULL OR o.price = :price) "
			+ "AND (:search IS NULL OR o.productName = %:search%) "
			+ "AND (:isInStock IS NULL OR o.isInStock = :isInStock) "
			+ "ORDER BY "
			+ "CASE WHEN :order = 'asc' THEN o.price END ASC, "
			+ "CASE WHEN :order = 'desc' THEN o.price END DESC")
	Page<Products> findByFilter(String brand, String category, String date, String gender, String order, Double price,
			String search, Boolean isInStock, Pageable page);
}
