package com.daadestroyer.springbootfullstackreactbloggingapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.daadestroyer.springbootfullstackreactbloggingapp.dto.CategoryDto;
import com.daadestroyer.springbootfullstackreactbloggingapp.service.impl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryServiceImpl categoryServiceImpl;

	// create
	// http://localhost:8080/category/save-category/
	@PostMapping("/save-category")
	public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
		CategoryDto savedCategoryDto = this.categoryServiceImpl.createCategory(categoryDto);
		return new ResponseEntity<>(savedCategoryDto, HttpStatus.OK);

	}

	// update
	@PutMapping("/update-category/{catId}")
	public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryDto categoryDto, @PathVariable int catId) {
		CategoryDto updatedCategory = this.categoryServiceImpl.updateCategory(categoryDto, catId);
		return new ResponseEntity<>(updatedCategory, HttpStatus.OK);

	}

	// get category
	// http://localhost:8080/category/get-single-category/1
	@GetMapping("/get-single-category/{catId}")
	public ResponseEntity<?> getSingleCategory(@PathVariable int catId) {
		CategoryDto singleCategory = this.categoryServiceImpl.getSingleCategory(catId);
		return new ResponseEntity<>(singleCategory, HttpStatus.OK);
	}

	// get all category
	// http://localhost:8080/category/get-all-category
	@GetMapping("/get-all-category")
	public ResponseEntity<?> getAllCategory() {
		List<CategoryDto> allCategory = this.categoryServiceImpl.getAllCategory();
		return new ResponseEntity<>(allCategory, HttpStatus.OK);
	}

	// delete category
	@DeleteMapping("/delete-category/{catId}")
	// http://localhost:8080/category/delete-category/1
	public ResponseEntity<?> deleteCategory(@PathVariable int catId) {
		String message = this.categoryServiceImpl.deleteCategoryById(catId);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
}
