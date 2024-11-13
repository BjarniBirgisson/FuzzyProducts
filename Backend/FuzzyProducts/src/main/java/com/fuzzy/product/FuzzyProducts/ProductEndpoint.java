package com.fuzzy.product.FuzzyProducts;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3010")
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
    public List<Product> getProducts() {
        System.out.println("Incoming API call for all products!");
        List<Product> products = this.productDatabase.findAll();
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
    public List<Product> fetchProduct(@PathVariable int id) {
        ArrayList<Product> result = new ArrayList<Product>();
        result.add(this.productDatabase.fetchProduct(id));
        if (!result.isEmpty() && result != null) {
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
     * Search for a product 
     * 
     * @param id to be fetched
     * @return the specific product
     */
    @GetMapping(value = "/search/{query}")
    public List<Product> fetchProduct(@PathVariable String query) {
        List<Product> products = Search.findProducts(query, this.productDatabase.findAll());
        return products;
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
