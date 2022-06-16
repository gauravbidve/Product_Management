package com.jbk.Product_Management.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.Product_Management.entity.Product;

@Repository
public class ProductDao_Impl implements ProductDao {

	@Autowired
	SessionFactory factory;

	@Override
	public Boolean saveProduct(Product product) {

		Session session = null;
		Boolean value = false;

		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(product);
			transaction.commit();
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return value;
	}

	@Override
	public Product getProductById(int productId) {
		Session session = null;
		Product product = null;
		try {
			session = factory.openSession();
			product = session.get(Product.class, productId);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		
		Session session = null;
		List<Product> products = null;
		
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(Product.class);
			products = criteria.list();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
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
