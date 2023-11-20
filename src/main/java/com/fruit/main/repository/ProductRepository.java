package com.fruit.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fruit.main.modal.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
//	@Query("SELECT p FROM Product P" +
//			"WHERE ((:minPrice IS NULL AND :maxPrice IS NULL) OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice))" + 
//			"AND (:discount IS NULL OR p.discountPersent>= :discount)" + 
//			"ORDER BY" + 
//			"CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC" +
//			"CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC"
//		)
//	public List<Product> filterProducts(@Param("category") String category, 
//			@Param("minPrice") Integer minPrice,
//			@Param("maxPrice") Integer maxPrice,
//			@Param("discount") Integer minDiscount,
//			@Param("sort") String sort
//			);
}
