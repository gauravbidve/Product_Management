package com.jbk.Product_Management.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
			Criteria criteria = session.createCriteria(Product.class);
			criteria.add(Restrictions.eq("product_name", product.getProduct_name()));
			Product prd = (Product) criteria.uniqueResult();
			if (prd == null) {
				Transaction transaction = session.beginTransaction();
				session.save(product);
				transaction.commit();
				value = true;
			}
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
			System.out.println(product);
		} catch (Exception e) {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return products;
	}

	@Override
	public Integer updateProduct(Product product) {

		Integer value = 0;
		Session session = null;

		try {
			session = factory.openSession();
			Product prd = session.get(Product.class, product.getProduct_id());
			System.out.println(prd);
			if (prd != null) {
				Criteria criteria = session.createCriteria(Product.class);
				criteria.add(Restrictions.eq("product_name", product.getProduct_name()));
				Product prdt = (Product) criteria.uniqueResult();
				if (prdt == null || (prdt.getProduct_id())==(product.getProduct_id())) {
					if(prdt!=null) {
						session.evict(prdt);
					}
					Transaction transaction = session.beginTransaction();
					session.update(product);
					transaction.commit();
					value=3;
				} else {
					value = 1;
				}
			} else {
				value = 2;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return value;
	}

	@Override
	public Boolean deleteProduct(int productId) {

		Boolean value = false;
		Session session = null;
		try {
			session = factory.openSession();
			Product prd = session.load(Product.class, productId);
			if (prd != null) {
				Transaction transaction = session.beginTransaction();
				session.delete(prd);
				transaction.commit();
				value = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return value;
	}

}
