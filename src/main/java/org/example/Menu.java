package org.example;

import java.util.List;

class Menu {
    private String name;
    private String description;

    private List<Product> products;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product){
        this.products.add(product);
    }
}
