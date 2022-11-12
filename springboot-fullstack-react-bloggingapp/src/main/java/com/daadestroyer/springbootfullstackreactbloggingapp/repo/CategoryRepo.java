package com.daadestroyer.springbootfullstackreactbloggingapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.daadestroyer.springbootfullstackreactbloggingapp.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
