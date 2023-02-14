package com.onetomany.services;

import java.util.List;

import com.onetomany.entities.Category;

public interface CategoryService {

	List<Category> getAllCategories(Integer pageNumber, Integer pageSize);

	public Category getCategoryById(long id);

	public void saveCategory(Category category);

	public void updateCategory(Category category, long id);

	public void deleteCategory(long id);

}
