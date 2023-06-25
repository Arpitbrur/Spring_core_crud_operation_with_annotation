package com.jsp.spring_crud_with_annotation.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

import com.jsp.spring_crud_with_annotation.dto.Product;

@Component
public class ProductDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	// insert Method	
	public Product insertproduct(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		return product;
	}
	
	// search method
	public Product searchProduct(int id) {
		return entityManager.find(Product.class, id);
	}
}
