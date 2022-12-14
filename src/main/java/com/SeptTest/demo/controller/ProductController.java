package com.SeptTest.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SeptTest.demo.dao.ProductDao;
import com.SeptTest.demo.model.Product;

@RestController
public class ProductController {

	private ProductDao productDao;

	ProductController(ProductDao productDao) {
		this.productDao = productDao;
	}

	@PostMapping("/item")
	public void createProduct(@RequestBody Product item) {
		productDao.createProduct(item);
	}

	@GetMapping("/item/{id}")
	public Product getProduct(@PathVariable int id) {
		return productDao.getProduct(id);
	}

	@GetMapping("/item/item")
	public List<Product> getAll() {
		return productDao.getAllProducts();
	}

	@PutMapping("/item/{name}")
	public void updateProduct(@PathVariable String name, @RequestBody Product item) {
		productDao.updateProduct(item);
	}

	@DeleteMapping("/item/{name}")
	public void DeleteProduct(@PathVariable String name) {
		productDao.deleteProduct(name);
	}
}
