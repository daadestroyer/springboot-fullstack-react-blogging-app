package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

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
	@NotEmpty(message = "please enter email")
	@Column(unique = true)
	private String userEmail;

	@NotEmpty(message = "please enter password")
	@Size(min = 3, max = 6, message = "password can't be less than 3 or greater than 6")
	private String password;

	@NotEmpty(message = "please enter about")
	@Size(min = 10, message = "about can't be less than 10")
	private String about;
	
	@JsonIgnore
	public String getPassword() {
		return this.password;
	}
	
	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}
	
	private Set<RoleDto> roles = new HashSet<>();

	
	
	
	
	 
}
