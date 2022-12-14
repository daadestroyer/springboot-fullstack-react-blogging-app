package com.daadestroyer.springbootfullstackreactbloggingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
