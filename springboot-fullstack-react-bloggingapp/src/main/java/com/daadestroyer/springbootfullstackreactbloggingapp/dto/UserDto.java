package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

	private int userId;

	@NotEmpty(message = "please enter username")
	@Size(min = 2, max = 30, message = "username can't be less than length of 2 or more than 30")
	private String userName;

	@Email(message = "please enter correct email")
	private String userEmail;

	@NotEmpty(message = "please enter password")
	@Size(min = 3, max = 6, message = "password can't be less than 3 or greater than 6")
	private String password;

	@NotEmpty(message = "please enter about")
	@Size(min = 10, max = 100, message = "about can't be less than 10 or greater than 100")
	private String about;
	
	 
}
