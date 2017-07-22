package com.tornado.swagger.controller;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tornado.swagger.entity.Product;

@RestController
@RequestMapping("/product")
@Api(value="onlinestore", description="Operations pertaining to products in Online Store")
public class ProductController {

	@ApiOperation(value = "View a list of available products",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved list"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/list", method= RequestMethod.GET, produces = "application/json")
    public Iterable<Product> list(){
      //  Iterable<Product> productList = productService.listAllProducts();
		List<Product> productList = new ArrayList<>();
		productList.add(simpleProduct());
		productList.add(simpleProduct());
		productList.add(simpleProduct());
        return productList;
    }
    @ApiOperation(value = "Search a product with an ID",response = Product.class)
    @RequestMapping(value = "/show/{id}", method= RequestMethod.GET, produces = "application/json")
    public Product showProduct(@PathVariable Integer id){
      // Product product = productService.getProductById(id);
        return simpleProduct();
    }
    @ApiOperation(value = "Add a product")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity saveProduct(@RequestBody Product product){
      //  productService.saveProduct(product);
        return new ResponseEntity("Product saved successfully", HttpStatus.OK);
    }
    @ApiOperation(value = "Update a product")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @RequestBody Product product){
//        Product storedProduct = productService.getProductById(id);
//        storedProduct.setDescription(product.getDescription());
//        storedProduct.setImageUrl(product.getImageUrl());
//        storedProduct.setPrice(product.getPrice());
      //  productService.saveProduct(storedProduct);
        return new ResponseEntity("Product updated successfully", HttpStatus.OK);
    }
    @ApiOperation(value = "Delete a product")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        //productService.deleteProduct(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);
    }
    
    Product simpleProduct(){
    	Product product = new Product();
    	product.setDescription("Product Desc");
    	product.setId(1);
    	product.setImageUrl("Product URL Image");
//    	product.setPrice(333);
    	product.setProductId("Product ID 834868746237846");
    	product.setVersion(1);
    	return product; 
    }
}
