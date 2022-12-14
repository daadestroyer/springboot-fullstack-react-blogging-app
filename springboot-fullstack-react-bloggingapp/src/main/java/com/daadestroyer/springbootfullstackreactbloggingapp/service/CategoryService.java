package com.daadestroyer.springbootfullstackreactbloggingapp.service;

import java.util.List;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CategoryDto;

public interface CategoryService {

	// create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	// update
	public CategoryDto updateCategory(CategoryDto categoryDto , int catId);
	   
	// get
	public CategoryDto getSingleCategory(int catId);
	
	// all
	public List<CategoryDto> getAllCategory();
	
	// delete
	public String deleteCategoryById(int catId); 
}
