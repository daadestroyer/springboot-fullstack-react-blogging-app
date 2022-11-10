package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.UserService;

 

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto addUser(UserDto userDto) {
		User savedUser = this.userRepo.save(this.modelMapper.map(userDto, User.class));
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public UserDto updateUser(UserDto userDto, int userId) {
		User savedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

		savedUser.setUserName(userDto.getUserName());
		savedUser.setUserEmail(userDto.getPassword());
		savedUser.setPassword(userDto.getPassword());
		savedUser.setAbout(userDto.getAbout());

		User updatedUser = this.userRepo.save(savedUser);
		return this.modelMapper.map(updatedUser, UserDto.class);
	}

	@Override
	public UserDto getUserById(int userId) {
		User savedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		return this.modelMapper.map(savedUser, UserDto.class);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<UserDto> listOfAllUsers = this.userRepo.findAll().stream().map(user -> this.modelMapper.map(user, UserDto.class))
				.collect(Collectors.toList());
		
		return listOfAllUsers;
	}

	@Override
	public String deleteUserById(int userId) {
		User savedUser = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(savedUser);
		
		return savedUser+" deleted sucessfully...";
	}

}
