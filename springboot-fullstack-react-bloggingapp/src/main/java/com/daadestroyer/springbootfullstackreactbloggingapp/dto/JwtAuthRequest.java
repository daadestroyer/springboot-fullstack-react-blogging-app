package com.daadestroyer.springbootfullstackreactbloggingapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class JwtAuthRequest {
	
	private String username;
	private String password;
}
