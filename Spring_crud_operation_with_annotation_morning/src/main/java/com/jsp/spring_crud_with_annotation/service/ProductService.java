package com.jsp.spring_crud_with_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jsp.spring_crud_with_annotation.dao.ProductDao;
import com.jsp.spring_crud_with_annotation.dto.Product;

@Component(value = "productService")
public class ProductService {

	@Autowired
	ProductDao dao;
	//ProductDao dao = new ProductDao();
	
		// insert Method	
		public Product insertproduct(Product product) {
			return dao.insertproduct(product);
		}
		
		// search method
		public Product searchProduct(int id) {
			return dao.searchProduct(id);
		}
}
