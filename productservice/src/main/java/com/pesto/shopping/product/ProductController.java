package com.pesto.shopping.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> getUser(@PathVariable("productId") Long productId) {
        return new ResponseEntity<Product>(productService.getProduct(productId), HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Product> addUser(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.addProduct(product), HttpStatus.OK);
    }


    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<Product> upDateUser(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.updateProduct(product), HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("productId") Long productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
    }

}
