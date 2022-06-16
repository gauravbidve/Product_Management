package com.jbk.Product_Management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.Product_Management.entity.Product;
import com.jbk.Product_Management.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {

		Boolean value = service.saveProduct(product);

		if (value) {
			return new ResponseEntity("Saved...!!!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity("Something went wrong...!!!", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam int productId){
		
		Product product = service.getProductById(productId);
		
		if(product!=null) {
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} else {
			return new ResponseEntity<Product>(product,HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products= service.getAllProduct();
		
		if(!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		
	}

}
