package com.jbk.Product_Management.dao;

import java.util.List;

import com.jbk.Product_Management.entity.Product;

public interface ProductDao {

	public Boolean saveProduct(Product product);
	public Product getProductById(int productId);
	public List<Product> getAllProduct();
	public Boolean updateProduct(Product product);
	public Boolean deleteProduct(int productId);
	
}
