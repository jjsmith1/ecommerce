package com.TTS.ecommerce.Models;

import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private long id;
	private int quantity;
	private double price;
	private String description;
	private String name;
	private String brand;
	private String category;
	private String image;
	
	
}
