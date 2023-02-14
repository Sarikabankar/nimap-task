package com.onetomany.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.onetomany.entities.Product;
import com.onetomany.repo.ProductRepo;
import com.onetomany.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepo productRepo;

//	@Override
//	public Page<Product> getAllProducts(int page) {
//		return productRepo.findAll(PageRequest.of(page, 5));
//	}

	@Override
	public List<Product> getAllProducts(Integer pageNumber, Integer pageSize) {

		Pageable p = PageRequest.of(pageNumber - 1, pageSize);

		Page<Product> page = productRepo.findAll(p);

		List<Product> list = page.getContent();

		return list;
	}

	@Override
	public Product getProductById(long id) {
		return productRepo.findById(id).orElseThrow();
	}

	@Override
	public void saveProduct(Product Product) {
		productRepo.save(Product);
	}

	@Override
	public void updateProduct(Product Product, long id) {
		productRepo.save(Product);
	}

	@Override
	public void deleteProduct(long id) {
		productRepo.deleteById(id);
	}
}
