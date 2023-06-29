package com.jsp.spring_crud_with_annotation.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.jsp.spring_crud_with_annotation.dto.Product;
import com.mysql.cj.x.protobuf.MysqlxCrud.Find;

@Component
public class ProductDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("arpit");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	
	
	// insert Method-----------------------------------------------------------------------	
	public Product insertproduct(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		return product;
	}
	
	// search method-----------------------------------------------------------------------
	public Product searchProduct(int id) {
		return entityManager.find(Product.class, id);
	}
	
	// update method----------------------------------------------------------------------
	public void updateProduct(Product product) {
		entityTransaction.begin();;
		entityManager.merge(product);
		entityTransaction.commit();
		
		System.out.println("Data updated Successfully");
	}
	
	// delete method-----------------------------------------------------------------------
	public void deleteProduct(int id) {
		Product product = entityManager.find(Product.class, id);
		
		entityTransaction.begin();
		entityManager.remove(product);
		entityTransaction.commit();
		
		System.out.println("Data deleted Successfully");
	}
	
	// display method----------------------------------------------------------------------
	public List<Product> displayProduct(){
		String select = "SELECT p FROM Product p";
		Query query = entityManager.createQuery(select);
		return query.getResultList();
	}
}
