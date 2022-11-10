package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.UserService;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceImpl userServiceImpl;

	// POST - save user
	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
		UserDto newUser = this.userServiceImpl.addUser(userDto);
		return new ResponseEntity<>(newUser, HttpStatus.OK);
	}

	// PUT - update user
	@PutMapping("/update-user/{userId}")
	public ResponseEntity<?> updateUser(@RequestBody UserDto userDto, @PathVariable int userId) {
		UserDto updateUser = this.userServiceImpl.updateUser(userDto, userId);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
	}

	// DELETE - delete user
	@DeleteMapping("/delete-user/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable int userId) {
		String message = this.userServiceImpl.deleteUserById(userId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	// GET - get user
	@GetMapping("/get-all-user")
	public ResponseEntity<?> getAllUser(){
		List<UserDto> allUsers = this.userServiceImpl.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
	}
}
