package com.jbk.Product_Management.exception;

public class ProductAlreadyExistsException extends RuntimeException {

	public ProductAlreadyExistsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductAlreadyExistsException(String message) {
		super("Product already exists with the given product name: "+message);
		// TODO Auto-generated constructor stub
	}
	
}
