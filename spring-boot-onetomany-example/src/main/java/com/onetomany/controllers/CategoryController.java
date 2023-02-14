package com.onetomany.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onetomany.entities.Category;
import com.onetomany.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping
	private List<Category> getAllCategories(@RequestParam int page, @RequestParam(defaultValue = "5") int pageSize) {
		return categoryService.getAllCategories(page, pageSize);
	}

	@GetMapping("/{id}")
	public Category getFoodCategoryById(@PathVariable long id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping
	public long saveFoodCategory(@RequestBody Category category) {
		categoryService.saveCategory(category);
		return category.getId();
	}

	@PutMapping("/{id}")
	public Category updateCategory(@RequestBody Category category, @PathVariable long id) {
		categoryService.updateCategory(category, id);
		return category;
	}

	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}
}
