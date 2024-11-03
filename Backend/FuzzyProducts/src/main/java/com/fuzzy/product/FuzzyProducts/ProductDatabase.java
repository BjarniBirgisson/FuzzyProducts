package com.fuzzy.product.FuzzyProducts;

import java.util.ArrayList;
import java.util.Objects;

import org.springframework.stereotype.Repository;

/**
 * Basic storeage class for all products instead of an actual database
 */
@Repository
public class ProductDatabase {
    
    // Counter for the productIds in the database
    private int idCount;
    
    // Products set
    private final ArrayList<Product> products;

    public ProductDatabase() {
        products = new ArrayList<Product>();
        init();
    }

    /**
     * Initialize the database
     */
    private void init() {
        // Clear the list of products
        this.products.clear(); 
        // Import the data from file and add all
        this.products.addAll(DataImporter.importData("../FuzzyProducts/src/main/resources/SampleData.csv"));
        
        // Reset ID count and Update all product IDs
        idCount = 0;
        while (idCount < products.size()) {
            products.get(idCount).setProductId(idCount);
            idCount++;
        }
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
     * Update a specific product id
     * @param id of product to update
     * @param product new updated attributes
     * @return return true if product was updated
     */
    public boolean updateProduct(int id, Product product) {
        int idx = products.indexOf(new Product(id));
        if (idx != -1) {
            Product p = products.get(idx);
            p.setName(Objects.nonNull(product.getName()) ? product.getName() : p.getName());
            p.setDescription(Objects.nonNull(product.getName()) ? product.getName() : p.getName());
            p.setPrice(Objects.nonNull(product.getPrice()) ? product.getPrice() : p.getPrice());
            p.setCategory(Objects.nonNull(product.getCategory()) ? product.getCategory() : p.getCategory());
            p.setImageUrl(Objects.nonNull(product.getImageUrl()) ? product.getImageUrl() : p.getImageUrl());
            return true;
        }
        return false;
    }
    
    /**
     * Fetch a specific product 
     * @param id of product to fetch
     * @return Product if exists, else return null
     */
    public Product fetchProduct(int id) {
        int idx = products.indexOf(new Product(id));
        if (idx != -1) {
            return products.get(idx);
        }
        return null;
    }
}
