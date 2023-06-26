package com.retail.ProductService.Categories;

import com.retail.ProductService.POJO.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
//@Builder
//@NoArgsConstructor
@AllArgsConstructor

public class ProductWrapper {


private Integer prod_id;

private String prod_name;

private Integer prod_price;

private String prod_image;

private String prod_desc;

private Integer stock;

public ProductWrapper() {
	// super();
	}



public Integer getProd_id() {
	return prod_id;
}

public void setProd_id(Integer prod_id) {
	this.prod_id = prod_id;
}

public String getProd_name() {
	return prod_name;
}

public void setProd_name(String prod_name) {
	this.prod_name = prod_name;
}

public Integer getProd_price() {
	return prod_price;
}

public void setProd_price(Integer prod_price) {
	this.prod_price = prod_price;
}

public String getProd_image() {
	return prod_image;
}

public void setProd_image(String prod_image) {
	this.prod_image = prod_image;
}

public String getProd_desc() {
	return prod_desc;
}

public void setProd_desc(String prod_desc) {
	this.prod_desc = prod_desc;
}

public Integer getStock() {
	return stock;
}

public void setStock(Integer stock) {
	this.stock = stock;
}

//public ProductWrapper(Integer prod_id, String prod_name, Integer prod_price, String prod_image, String prod_desc,
//		Boolean stock) {
////	super();
//	this.prod_id = prod_id;
//	this.prod_name = prod_name;
//	this.prod_price = prod_price;
//	this.prod_image = prod_image;
//	this.prod_desc = prod_desc;
//	this.stock = stock;
//}





}
