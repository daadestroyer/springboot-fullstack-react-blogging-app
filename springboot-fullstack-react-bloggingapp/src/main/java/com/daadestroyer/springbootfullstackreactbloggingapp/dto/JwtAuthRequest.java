package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtAuthRequest {
	
	@NotEmpty(message = "please enter username")
	@Size(min = 2, max = 30, message = "username can't be less than length of 2 or more than 30")
	private String username;
	
	
	@NotEmpty(message = "please enter password")
	@Size(min = 3, max = 6, message = "password can't be less than 3 or greater than 6")
	private String password;
}
