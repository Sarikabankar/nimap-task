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

import com.onetomany.entities.Product;
import com.onetomany.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	private List<Product> getAllProducts(@RequestParam int page, @RequestParam(defaultValue = "5") int pageSize) {
		return productService.getAllProducts(page, pageSize);
	}

	@GetMapping("/{id}")
	private Product getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}

	@PostMapping
	private long saveProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product.getId();
	}

	@PutMapping("/{id}")
	private Product updateProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product;
	}

	@DeleteMapping("/{id}")
	private void deleteProduct(@PathVariable long id) {
		productService.deleteProduct(id);
	}

}
