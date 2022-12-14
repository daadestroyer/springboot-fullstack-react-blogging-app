package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.constant.RoleConstant;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Role;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.RoleRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto registerUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);

		// encode the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));

		// assign the role
		Role role = this.roleRepo.findById(RoleConstant.ROLE_USER).get();
		System.out.println("ROLE = "+role);
		
		// save the role
		user.getRoles().add(role);

		// save the user
		User newUser = this.userRepo.save(user);

		return this.modelMapper.map(newUser, UserDto.class);
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
		List<UserDto> listOfAllUsers = this.userRepo.findAll().stream()
				.map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

		return listOfAllUsers;
	}

	@Override
	public String deleteUserById(int userId) {
		User savedUser = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(savedUser);

		return savedUser + " deleted sucessfully...";
	}

	

}
