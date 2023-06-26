package com.retail.ProductService.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;

public interface ProductServices {

	ResponseEntity<List<Product>> viewAllProduct();

	ResponseEntity<Optional<Product>>  findProductById(Integer id);

	ResponseEntity<List<ProductWrapper>> getByCategoryid(Integer category_id);

	ResponseEntity<List<ProductWrapper>> getByName(String name);
	
	Integer updateStock (List<Product> product);
	

	
//	ResponseEntity<ProductWrapper> findByNameLike(String name);


}
