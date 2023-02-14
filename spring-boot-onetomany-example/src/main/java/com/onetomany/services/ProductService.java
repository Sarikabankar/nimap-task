package com.onetomany.services;

import java.util.List;

import com.onetomany.entities.Product;

public interface ProductService {
	
	List<Product> getAllProducts(Integer pageNumber, Integer pageSize);

	public Product getProductById(long id);

	public void saveProduct(Product product);

	public void updateProduct(Product product, long id);

	public void deleteProduct(long id);

}
