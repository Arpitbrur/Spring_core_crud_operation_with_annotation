package com.jsp.spring_crud_with_annotation.controller;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jsp.spring_crud_with_annotation.MyConfig;
import com.jsp.spring_crud_with_annotation.dto.Product;
import com.jsp.spring_crud_with_annotation.service.ProductService;

public class ProductController {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
		
		ProductService productService = (ProductService) applicationContext.getBean("productService");
		Product product = (Product) applicationContext.getBean("product");
		
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("Entrt your choice");
			System.out.println("1. Insert\n2. GetById\n3. Update\n4. Delete\n5. Display\n6. Exit");
			int ch= sc.nextInt();
			switch (ch) {
			case 1:{
				System.out.println("Enter product id");
				product.setId(sc.nextInt());
				System.out.println("Enter product Name");
				product.setName(sc.next());
				System.out.println("Enter product Price");
				product.setPrice(sc.nextDouble());
				productService.insertproduct(product);
				
			}break;
				
			case 2:{
				System.out.println("Enter the product id you want to fetch");
				Product product1 = productService.searchProduct(sc.nextInt());
				
				if(product1 != null) {
					System.out.println("=========================");
					System.out.println("Product Id:-"+product1.getId());
					System.out.println("product name:-"+product1.getName());
					System.out.println("product Price:-"+product1.getPrice());
					System.out.println("=========================");

				}else {
					System.out.println("Plz check your product id you have passed");
				}
			}break;
			
			case 3:{
				System.out.println("Enter product id");
				product.setId(sc.nextInt());
				System.out.println("Enter product Name");
				product.setName(sc.next());
				System.out.println("Enter product Price");
				product.setPrice(sc.nextDouble());
				
				productService.updateProduct(product);
			}break;
			
			case 4:{
				System.out.println("Enter the product id which are you deleted");
				int productId = sc.nextInt();
				productService.deleteProduct(productId);
			}break;
			
			case 5:{
				List<Product> list = productService.displayProduct();
				if(list != null) {
					System.out.println("============Product Details============");
					for (Product product2 : list) {
						System.out.println("productId:- "+product2.getId());
						System.out.println("productName:- "+product2.getName());
						System.out.println("productPrice:- "+product2.getPrice());
						System.out.println("=======================================");
					}
				}else {
					System.out.println("table is empty in database");
				}
			}break;
			
			case 6:{
				System.out.println("System Closed......");
				System.exit(ch);
			}break;
			
			default:{
				System.out.println("Invalid choice.....");
			}
		 }
		}
		
	}
}
