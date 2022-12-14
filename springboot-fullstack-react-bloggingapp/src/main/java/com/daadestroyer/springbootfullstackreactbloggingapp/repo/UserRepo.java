package com.daadestroyer.springbootfullstackreactbloggingapp.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	
	public Optional<User> findByuserEmail(String email);
}
