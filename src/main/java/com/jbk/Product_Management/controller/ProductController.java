package com.jbk.Product_Management.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jbk.Product_Management.entity.Product;
import com.jbk.Product_Management.exception.EmptyTableException;
import com.jbk.Product_Management.exception.ProductAlreadyExistsException;
import com.jbk.Product_Management.exception.ProductNotFoundException;
import com.jbk.Product_Management.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService service;

	@PostMapping("/saveProduct")
	public ResponseEntity<String> saveProduct(@Valid @RequestBody Product product) {

		Boolean value = service.saveProduct(product);

		if (value) {
			return new ResponseEntity("Saved...!!!", HttpStatus.CREATED);
		} else {
			//return new ResponseEntity("Something went wrong...!!!", HttpStatus.INTERNAL_SERVER_ERROR);
			throw new ProductAlreadyExistsException(product.getProduct_name());
		}

	}
	
	@GetMapping("/getProductById")
	public ResponseEntity<Product> getProductById(@RequestParam int productId){
		
		Product product = service.getProductById(productId);
		String pid = String.valueOf(productId);
		
		if(product!=null) {
			return new ResponseEntity<Product>(product,HttpStatus.OK);
		} else {
			throw new ProductNotFoundException(pid);
		}
		
	}
	
	@GetMapping("/getAllProducts")
	public ResponseEntity<List<Product>> getAllProducts(){
		
		List<Product> products= service.getAllProduct();
		
		if(!products.isEmpty()) {
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		} else {
			//return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
			throw new EmptyTableException();
		}
		
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {

		Integer value = service.updateProduct(product);

		if (value == 3) {
			return new ResponseEntity<Product>(product, HttpStatus.CREATED);
		} else if (value == 1) {
			// return new ResponseEntity("Record with the given productId is not
			// available",HttpStatus.NOT_FOUND);
			throw new ProductAlreadyExistsException(product.getProduct_name());
		} else {
			String pid = String.valueOf(product.getProduct_id());
			throw new ProductNotFoundException(pid);
		}

	}

	@DeleteMapping("/deleteProduct")
	public ResponseEntity<String> deleteProduct(@RequestParam int productId){
		
		Boolean value = service.deleteProduct(productId);
		String pid = String.valueOf(productId);
		
		if(value) {
			return new ResponseEntity<String>("Product deleted Succefully",HttpStatus.ACCEPTED);
		} else {
			//return new ResponseEntity<String>("Product doesn't exist with the given productId",HttpStatus.NOT_FOUND);
			throw new ProductNotFoundException(pid);
		}
		
	}
	
	@GetMapping("/generateReport")
	public ResponseEntity<String> generateReport(@RequestParam String format){
		
		String msg = service.getReport(format);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);	
	}

}
