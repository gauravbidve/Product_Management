package com.jbk.Product_Management.service;

import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jbk.Product_Management.dao.ProductDao;
import com.jbk.Product_Management.entity.Product;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

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
	public Integer updateProduct(Product product) {
		Integer value = dao.updateProduct(product);
		return value;
	}

	@Override
	public Boolean deleteProduct(int productId) {
		Boolean value = dao.deleteProduct(productId);
		return value;
	}

	@Override
	public String getReport(String format) {
		
		String destination = "E:\\Gaurav Java\\Screenshots & Materials\\OJT\\Jasper Report";
		List<Product> products = dao.getAllProduct();
		
		try {
			File file = ResourceUtils.getFile("classpath:Product2.jrxml");
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(products);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
			
			if(format.equalsIgnoreCase("pdf")) {
				JasperExportManager.exportReportToPdfFile(jasperPrint,destination+"\\ProductManagement.pdf");
				destination = "File Generated at "+destination;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return destination;
	}

}
