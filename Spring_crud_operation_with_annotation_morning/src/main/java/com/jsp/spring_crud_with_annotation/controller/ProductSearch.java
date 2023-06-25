package com.jsp.spring_crud_with_annotation.controller;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring_crud_with_annotation.MyConfig;
import com.jsp.spring_crud_with_annotation.dto.Product;
import com.jsp.spring_crud_with_annotation.service.ProductService;

public class ProductSearch {

	public static void main(String[] args) {
		
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		
		ProductService productService = (ProductService) applicationContext.getBean("productService");
		Product product = (Product) applicationContext.getBean("product");
		
		Scanner sc = new Scanner(System.in);
		
		
		
		
	}
}
