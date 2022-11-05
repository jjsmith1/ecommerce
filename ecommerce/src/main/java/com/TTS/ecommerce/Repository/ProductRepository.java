package com.TTS.ecommerce.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.collections.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findall();
	Product findById(long id);
	List<Product> findByBrand(String brand);
	List<Product> findByCategory(String category);
	List<Product> findByBrandAndCategory(String brand, String category);
	
	@Query("SELECT DISTINCT p.brand FROM Product p")
	List<Product> findDistinctBrand();
	
	@Query("SELECT DISTINCT p.category FROM Product p")
	
	List<String>findDistinctCategories();
}
