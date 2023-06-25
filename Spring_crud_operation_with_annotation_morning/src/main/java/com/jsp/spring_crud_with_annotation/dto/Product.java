package com.jsp.spring_crud_with_annotation.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component(value = "product")
public class Product {
	@Id
	private int id;
	private String name;
	private double price;
	
	
}
