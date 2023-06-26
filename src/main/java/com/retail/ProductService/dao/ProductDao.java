package com.retail.ProductService.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;

public interface ProductDao extends JpaRepository<Product,Integer>{

	List<ProductWrapper> findAllBycategory_id(Integer category_id);
	
   @Transactional
   @Modifying
   @Query("update Product p set p.stock=p.stock-:qty where p.prod_id= :prodId")
	Integer updateStock (@Param ("prodId") Integer prodId,@Param ("qty") Integer qty);
	
	

//	Product findAllBycategoryId(Integer category_id);

//	List<ProductWrapper> findAllByprod_name(String string, String string2);
	
	//List<ProductWrapper> findAllByName(String name);

	//Product getProductById(@Param("id")Integer id);
}
