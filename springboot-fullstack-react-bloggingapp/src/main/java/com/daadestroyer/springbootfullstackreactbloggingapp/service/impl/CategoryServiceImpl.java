package com.daadestroyer.springbootfullstackreactbloggingapp.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CategoryDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.exception.ResourceNotFoundException;
import com.daadestroyer.springbootfullstackreactbloggingapp.model.Category;
import com.daadestroyer.springbootfullstackreactbloggingapp.repo.CategoryRepo;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.CategoryService;



@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category savedCategory = this.categoryRepo.save(this.modelMapper.map(categoryDto, Category.class));
		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, int catId) {
		Category savedCategory = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", catId));
		savedCategory.setCatTitle(categoryDto.getCatTitle());
		savedCategory.setCatDesc(categoryDto.getCatDesc());
		Category newCategory = this.categoryRepo.save(savedCategory);
		return this.modelMapper.map(newCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto getSingleCategory(int catId) {
		Category savedCategory = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", catId));
		return this.modelMapper.map(savedCategory, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<CategoryDto> listOfCategoryDtos = this.categoryRepo.findAll().stream()
				.map(cat -> this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return listOfCategoryDtos;
	}

	@Override
	public String deleteCategoryById(int catId) {
		Category savedCategory = this.categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", catId));
		this.categoryRepo.delete(savedCategory);
		return savedCategory + " deleted sucessfully...";
	}

}
