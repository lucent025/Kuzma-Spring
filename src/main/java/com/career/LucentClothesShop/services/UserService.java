package com.career.LucentClothesShop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.career.LucentClothesShop.model.Users;
import com.career.LucentClothesShop.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public Optional<Users> getUserById(int id) {
		return userRepository.findById(id);
	}
}
