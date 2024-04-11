package com.career.LucentClothesShop.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.career.LucentClothesShop.model.Users;
import com.career.LucentClothesShop.services.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Users>> getUserById(@PathVariable int id) {
		return new ResponseEntity<Optional<Users>>(userService.getUserById(id), HttpStatus.OK);
	}
}
