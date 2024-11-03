package com.fuzzy.product.FuzzyProducts;

import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = "application/json")
public class ProductEndpoint {

    /**
     * Data available in the endpoint
     */
    private final ProductDatabase productDatabase;

    public ProductEndpoint() {
        this.productDatabase = new ProductDatabase();

    }

    /**
     * Get all products
     * 
     * @return all products in database
     */
    @GetMapping(value = "/products")
    public List<?> getProducts() {
        List<?> products = this.productDatabase.findAll();
        return products;
    }

    /**
     * Add a new Product to the database
     * 
     * @param product to be added
     * @return
     */
    @PostMapping(value = "/products")
    public ResponseEntity<Product> newProduct(@RequestBody Product product) {
        boolean added = this.productDatabase.add(product);
        if (added) {
            return new ResponseEntity<Product>(product, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Update attributes of an existing product
     * 
     * @param id      to be updated
     * @param product product attributes to be updated
     * @return
     */
    @PutMapping(value = "/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable int id, @RequestBody Product product) {
        boolean updated = this.productDatabase.updateProduct(id, product);
        if (updated) {
            return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Fetch specific product from the database
     * 
     * @param id to be fetched
     * @return the specific product
     */
    @GetMapping(value = "/products/{id}")
    public Product fetchProduct(@PathVariable int id) {
        Product result = this.productDatabase.fetchProduct(id);
        if (result != null) {
            return result;
        }
        return null;
    }

    /**
     * Delete specific product from the database
     * 
     * @param id of product to be deleted
     * @return
     */
    @DeleteMapping(value = "/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
        boolean result = this.productDatabase.deleteProduct(id);
        if (result) {
            return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    /**
     *  Getters and Setters below
     */
    
    public ProductDatabase getProductDatabase() {
        return productDatabase;
    }
    
    public ProductDatabase setProductDatabase() {
        return productDatabase;
    }


}
