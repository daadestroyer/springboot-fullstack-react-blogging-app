package com.daadestroyer.springbootfullstackreactbloggingapp;

import java.util.Arrays;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.daadestroyer.springbootfullstackreactbloggingapp.constant.RoleConstant;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Role;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.RoleRepo;



@SpringBootApplication
public class SpringbootFullstackReactBloggingappApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;
	
	public static void main(String[] args) {
	 
		SpringApplication.run(SpringbootFullstackReactBloggingappApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("pwd1");
		//System.out.println(this.passwordEncoder.encode("pwd1"));
		
		
		// AT THE START OF THIS APP 2 DEFAULT ROLES GET ASSIGNED AUTOMATICALLY
		Role role1 = new Role();
		role1.setId(RoleConstant.ROLE_ADMIN);
		role1.setRole("ROLE_ADMIN");
		
		Role role2 = new Role();
		role2.setId(RoleConstant.ROLE_USER);
		role2.setRole("ROLE_USER");
		
		List<Role> roles = List.of(role1,role2);
		List<Role> result = this.roleRepo.saveAll(roles);
		System.out.println("Default role assigned"+roles);
	}
}
