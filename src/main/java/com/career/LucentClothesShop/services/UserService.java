package com.career.LucentClothesShop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
	
	public Optional<Users> getUserByEmail(String email) {
		Users userEmail = new Users();
		userEmail.setEmail(email);
		Example<Users> userEmailExample = Example.of(userEmail);
		return userRepository.findOne(userEmailExample);
	}
}
