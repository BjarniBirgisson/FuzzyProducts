package com.fuzzy.product.FuzzyProducts;

import java.util.ArrayList;
import org.springframework.stereotype.Repository;

/**
 * Basic storeage class for all products instead of an actual database
 */
@Repository
public class ProductDatabase {
    
    // Counter for the productIds in the database
    private int idCount;
    
    private final ArrayList<Product> products;

    public ProductDatabase() {
        products = new ArrayList<Product>();
        idCount = 0;
    }

    public ProductDatabase(ArrayList<Product> products) {
        // Assign all products with a productId
        idCount = 0;
        while (idCount < products.size()) {
            products.get(idCount).setProductId(idCount);
            idCount++;
        }
        this.products = products;
        
    }

    /**
     * Get all products from the Database class
     * 
     * @return List of Product
     */
    public ArrayList<Product> findAll() {
        return products;
    }

    /**
     * Add a product to the Database and increment the idCount
     * 
     * @param product
     * @return true if added successfully
     */
    public boolean add(Product product) {
        try {
            product.setProductId(idCount);
            idCount++;
            products.add(product);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Delete a specific Product id from the database
     * @param id of product to delete
     * @return true if deletion was successful, false if no product could be deleted
     */
    public boolean deleteProduct(int id) {
        int idx = products.indexOf(new Product(id));
        if (idx != -1) {
            products.remove(idx);
            return true;
        }
        return false;
    }

    /**
     * Update a specfic product id
     * @param id of product to update
     * @param product new updated attributes
     * @return return true if product was updated
     */
    public boolean updateProduct(int id, Product product) {
        int idx = products.indexOf(product);
        if (idx != -1) {
            Product p = products.get(idx);
            p.setName(product.getName());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setCategory(product.getCategory());
            p.setImageUrl(product.getImageUrl());
            return true;
        }
        return false;
    }
}
