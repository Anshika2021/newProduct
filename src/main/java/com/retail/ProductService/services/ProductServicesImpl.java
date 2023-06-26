package com.retail.ProductService.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;
import com.retail.ProductService.dao.ProductDao;

@Service
public class ProductServicesImpl implements ProductServices{

	@Autowired 
	ProductDao productDao;
	
	@Override
	public ResponseEntity<List<Product>> viewAllProduct() {
		
		try {
			List<Product>products =  productDao.findAll();
			
			if(!Objects.isNull(products))
			{
			return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<>(products,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<Optional<Product>> findProductById(Integer id) {
		Optional<Product> productn=Optional.of(new Product());
		try {
			Optional<Product> product =  productDao.findById(id);
			if(!Objects.isNull(product))
			{
			return new ResponseEntity<>(product,HttpStatus.OK);
			}
			else
			{
				return new ResponseEntity<Optional<Product>>(product,HttpStatus.BAD_REQUEST);
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(productn,HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getByCategoryid(Integer category_id) {
		try {
			List<ProductWrapper>productWrapper = productDao.findAllBycategory_id(category_id);
			return new ResponseEntity<List<ProductWrapper>>(productWrapper, HttpStatus.OK);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<List<ProductWrapper>> getByName(String name) {
		try {
			List<ProductWrapper> product= new ArrayList<>();
			List<Product>products =  productDao.findAll();
			System.out.println(products);
			for(int i =0; i< products.size(); i++)
			{
				
				if(check(name,products.get(i).getProd_name()) == true)
				{
					System.out.println(products.get(i).getProd_name());
					ProductWrapper wrappedProduct = new ProductWrapper();
					
					wrappedProduct.setProd_id(products.get(i).getProd_id());
					wrappedProduct.setProd_name(products.get(i).getProd_name());
					wrappedProduct.setProd_image(products.get(i).getProd_image());
					wrappedProduct.setProd_desc(products.get(i).getProd_desc());
					wrappedProduct.setProd_price(products.get(i).getProd_price());
//  				     wrappedProduct.setStock(products.get(i).getStock());

					System.out.print(wrappedProduct.getProd_name());
					product.add(wrappedProduct);
				}

			}
			if(!product.isEmpty()) {
				return new ResponseEntity<List<ProductWrapper>>(product, HttpStatus.OK);

			}
			return new ResponseEntity<List<ProductWrapper>>(product,HttpStatus.NOT_FOUND);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return new ResponseEntity<List<ProductWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	boolean check(String prod_name, String name)
	{
		
		
		if(name.toUpperCase().startsWith(prod_name.toUpperCase() ) || (name.toUpperCase().contains(prod_name.toUpperCase())))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	
	@Override
	public Integer updateStock(List<Product> product) {
		
		for(int i =0; i<product.size(); i++) {
			productDao.updateStock(product.get(i).getProd_id(),product.get(i).getStock());
			
		}
      return 1;		
		
	}
	
	

	
	
}
