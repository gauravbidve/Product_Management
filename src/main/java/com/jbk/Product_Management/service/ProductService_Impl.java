package com.jbk.Product_Management.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jbk.Product_Management.dao.ProductDao;
import com.jbk.Product_Management.entity.Product;

@Service
public class ProductService_Impl implements ProductService {

	@Autowired
	ProductDao dao;

	@Override
	public Boolean saveProduct(Product product) {

		Boolean value = dao.saveProduct(product);

		return value;
	}

	@Override
	public Product getProductById(int productId) {
		
		Product product = dao.getProductById(productId);
		
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		
		List<Product> products = dao.getAllProduct();
		return products;
	}

	@Override
	public Boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

}
