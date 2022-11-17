package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.JwtAuthRequest;
import com.daadestroyer.springbootfullstackreactbloggingapp.dto.JwtAuthResponse;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.impl.CustomUserDetailService;
import com.daadestroyer.springbootfullstackreactbloggingapp.util.JwtUtil;

@RestController
@RequestMapping("/token")
public class JwtController {

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailService customUserDetailService;

	@PostMapping("/login")
	public ResponseEntity<?> createToken(@RequestBody JwtAuthRequest jwtAuthRequest) throws Exception {
		// this line will validate the username and password if authentication is
		// success then we can generate token
		System.out.println("JWT Authrequest = " + jwtAuthRequest);

		this.authenticate(jwtAuthRequest.getUsername(), jwtAuthRequest.getPassword());

		// if there is no exception just generate the token

		String generateToken = this.jwtUtil.generateToken(jwtAuthRequest.getUsername());

		return ResponseEntity.ok(new JwtAuthResponse(generateToken));
	}

	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			this.authenticationManager.authenticate(authenticationToken);
		} catch (BadCredentialsException e) {
			System.out.println("Invalid Details");
			throw new Exception("invalid username/password!!!");
			// TODO: handle exception
		}

	}
}
