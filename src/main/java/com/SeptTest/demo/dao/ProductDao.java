package com.SeptTest.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import com.SeptTest.demo.model.Product;

@Component
public class ProductDao {

	private static int i = 0;

	private static List<Product> items = new ArrayList<>();

	// Creates Item and adds to List
	public Product createProduct(Product product) {
		if (product.getId() == 0) {
			product.setId(++i);
		}

		items.add(product);
		return product;
	}

	// Returns the product with the specific ID
	public Product getProduct(int id) {
		Predicate<? super Product> predicate = product -> product.getId() == id;
		return items.stream().filter(predicate).findFirst().orElse(null);
	}

	// Returns all the Items present in the List
	public List<Product> getAllProducts() {
		return items;
	}

	// Updates Item
	public String updateProduct(Product product) {
		boolean productFound = false;
		for (Product currentProducts : items) {
			if (currentProducts.getName().equals(product.getName())) {
				productFound = true;

				currentProducts.setDescription(product.getDescription());
				currentProducts.setCost(product.getCost());
			}
		}
		if (productFound == false) {
			product.setId(++i);
			items.add(product);
		}
		return "Product Updated";
	}

	// Deletes product
	public void deleteProduct(String name) {
		Predicate<? super Product> predicate = product -> product.getName().equals(name);
		items.removeIf(predicate);
	}

}

