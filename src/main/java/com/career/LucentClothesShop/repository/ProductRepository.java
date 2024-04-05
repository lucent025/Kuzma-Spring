package com.career.LucentClothesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.LucentClothesShop.model.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
