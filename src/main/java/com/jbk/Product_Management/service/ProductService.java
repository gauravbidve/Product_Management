package com.jbk.Product_Management.service;

import java.util.List;

import com.jbk.Product_Management.entity.Product;

public interface ProductService {

	public Boolean saveProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProduct();
	public Boolean updateProduct(Product product);
	public Boolean deleteProduct(int productId);
	
}
