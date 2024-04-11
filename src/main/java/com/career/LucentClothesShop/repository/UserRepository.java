package com.career.LucentClothesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.career.LucentClothesShop.model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer>{
	
}
