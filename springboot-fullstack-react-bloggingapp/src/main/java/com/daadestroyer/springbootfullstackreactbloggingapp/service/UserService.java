package com.daadestroyer.springbootfullstackreactbloggingapp.service;

import java.util.List;

 
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.UserDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;


public interface UserService {

	public UserDto registerUser(UserDto userDto);
	
	//public UserDto registerNewUser(UserDto userDto);

	public UserDto updateUser(UserDto userDto, int userId);

	public UserDto getUserById(int userId);

	public List<UserDto> getAllUsers();

	public String deleteUserById(int userId);

}
