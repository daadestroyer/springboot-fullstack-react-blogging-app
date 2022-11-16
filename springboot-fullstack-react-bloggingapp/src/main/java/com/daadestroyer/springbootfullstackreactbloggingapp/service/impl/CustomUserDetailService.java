package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.UserRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = this.userRepo.findByuserEmail(username)
				.orElseThrow(() -> new ResourceNotFoundException("User", "email", username));
			
		
		return user;
	}

}
