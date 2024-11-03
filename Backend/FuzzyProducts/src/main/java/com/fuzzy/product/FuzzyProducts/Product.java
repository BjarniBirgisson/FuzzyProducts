package com.fuzzy.product.FuzzyProducts;

public class Product {
    private int productId;
    private String name;
    private String category;
    private String description;
    private float price;
    private String imageUrl;

    public Product() {
    }
    
    public Product(String name, String category, String description, float price, String imageUrl) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    /**
     * Override of equals function to compare only product IDs of the product
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return ((Product) o).getProductId() == this.productId;
        }
        return false;
    }

}
