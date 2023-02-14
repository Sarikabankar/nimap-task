package com.onetomany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.onetomany.entities.Category;
import com.onetomany.repo.CategoryRepo;
import com.onetomany.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

//	read
	@Override
	public List<Category> getAllCategories(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber - 1, pageSize);

		Page<Category> page = categoryRepo.findAll(p);

		List<Category> list = page.getContent();

		return list;
	}
// read
	@Override
	public Category getCategoryById(long id) {
		return categoryRepo.findById(id).orElseThrow();
	}
	
//	public List<Category> getAll(){
//		return categoryRepo.findAll();
//		
//	}

//	Create
	@Override
	public void saveCategory(Category Category) {
		categoryRepo.save(Category);
	}

//	Update
	@Override
	public void updateCategory(Category Category, long id) {
		categoryRepo.save(Category);
	}

//	Delete
	@Override
	public void deleteCategory(long id) {
		categoryRepo.deleteById(id);
	}
}
