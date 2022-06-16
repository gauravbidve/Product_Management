package com.jbk.Product_Management.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                       //It maps the Class with the Table
@Table(name="products")       //It is Optional, It is used when the Table name is different then class Name
public class Product {

	@Id                       //It indicates the Primary key
	@GeneratedValue(strategy = GenerationType.AUTO)   //It is used to AutoIncrement the column in DB
	@Column(nullable = false) //ProductId won't accept the Null Values, If the column name is different then variable name then we define the column name in @column(name="product_id") annotation
	private int productId;
	@Column(unique = true)    //productName column will accept only unique values
	private String productName;
	private int supplierId;
	private String quantityPerUnit;
	private long productPrice;
	private int productInStock;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productId, String productName, int supplierId, String quantityPerUnit, long productPrice,
			int productInStock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.productPrice = productPrice;
		this.productInStock = productInStock;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductInStock() {
		return productInStock;
	}

	public void setProductInStock(int productInStock) {
		this.productInStock = productInStock;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", supplierId=" + supplierId
				+ ", quantityPerUnit=" + quantityPerUnit + ", productPrice=" + productPrice + ", productInStock="
				+ productInStock + "]";
	}

}
