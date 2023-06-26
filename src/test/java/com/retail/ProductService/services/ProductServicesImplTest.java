

package com.retail.ProductService.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.retail.ProductService.Categories.ProductWrapper;
import com.retail.ProductService.POJO.Product;
import com.retail.ProductService.dao.ProductDao;


public class ProductServicesImplTest {

    private ProductServicesImpl productServicesImpl;
    private ProductDao productDaoMock;

    @BeforeEach
    public void setup() {

        productDaoMock = mock(ProductDao.class);
        productServicesImpl = new ProductServicesImpl();
        productServicesImpl.productDao = productDaoMock;
    }

    @Test
    public void testFindProductById() {
       
        Integer prod_id = 1;
        Product product = new Product();
        product.setProd_id(prod_id);
        Optional<Product> optionalProduct = Optional.of(product);
        when(productDaoMock.findById(prod_id)).thenReturn(optionalProduct);

        
        ResponseEntity<Optional<Product>> response = productServicesImpl.findProductById(prod_id);

        
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(optionalProduct, response.getBody());
    }
    
     @Test
        public void testViewAllProduct() {

    	    List<Product> products = new ArrayList<>();
            products.add(new Product());
            products.add(new Product());
            when(productDaoMock.findAll()).thenReturn(products);

           
            ResponseEntity<List<Product>> response = productServicesImpl.viewAllProduct();

           
            assertEquals(HttpStatus.OK, response.getStatusCode());
            assertEquals(products, response.getBody());
        }
     
     
     @Test
     public void testGetByCategoryId_Success() {
         // Arrange
         Integer categoryId = 1;
         List<ProductWrapper> expectedProductWrapper = new ArrayList<>();
         // Mock the behavior of the productDao
         when(productDaoMock.findAllBycategory_id(categoryId)).thenReturn(expectedProductWrapper);

         // Act
         ResponseEntity<List<ProductWrapper>> response = productServicesImpl.getByCategoryid(categoryId);

         // Assert
         assertEquals(HttpStatus.OK, response.getStatusCode());
         assertEquals(expectedProductWrapper, response.getBody());
     }

     @Test
     public void testGetByCategoryId_Exception() {
         // Arrange
         Integer categoryId = 1;
         // Mock the behavior of the productDao to throw an exception
         when(productDaoMock.findAllBycategory_id(categoryId)).thenThrow(new RuntimeException());

         // Act
         ResponseEntity<List<ProductWrapper>> response = productServicesImpl.getByCategoryid(categoryId);

         // Assert
         assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
         assertEquals(new ArrayList<>(), response.getBody());
     }
 
//     @Test
//     public void testGetByName_Success() {
//         // Arrange
//         String productName = "Test Product";
//         Product product = new Product();
//         product.setProd_name(productName);
//         List<Product> products = new ArrayList<>();
//         products.add(product);
//         // Mock the behavior of the productDao
//         when(productDaoMock.findAll()).thenReturn(products);
//
//         // Act
//         ResponseEntity<ProductWrapper> response = productServicesImpl.getByName(productName);
//
//         // Assert
//         assertEquals(HttpStatus.OK, response.getStatusCode());
//         ProductWrapper expectedProductWrapper = new ProductWrapper();
//         expectedProductWrapper.setProd_id(product.getProd_id());
//         expectedProductWrapper.setProd_name(product.getProd_name());
//         expectedProductWrapper.setProd_image(product.getProd_image());
//         expectedProductWrapper.setProd_desc(product.getProd_desc());
//         expectedProductWrapper.setProd_price(product.getProd_price());
//         assertEquals(expectedProductWrapper, response.getBody());
//     }
//
//     @Test
//     public void testGetByName_NotFound() {
//         // Arrange
//         String productName = "Nonexistent Product";
//         // Mock the behavior of the productDao with an empty list of products
//         when(productDaoMock.findAll()).thenReturn(new ArrayList<>());
//
//         // Act
//         ResponseEntity<ProductWrapper> response = productServicesImpl.getByName(productName);
//
//         // Assert
//         assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
//         assertEquals(new ProductWrapper(), response.getBody());
//     }
//
//     @Test
//     public void testGetByName_Exception() {
//         // Arrange
//         String productName = "Test Product";
//         // Mock the behavior of the productDao to throw an exception
//         when(productDaoMock.findAll()).thenThrow(new RuntimeException());
//
//         // Act
//         ResponseEntity<ProductWrapper> response = productServicesImpl.getByName(productName);
//
//         // Assert
//         assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//         assertEquals(new ProductWrapper(), response.getBody());
//     }
 }
   


