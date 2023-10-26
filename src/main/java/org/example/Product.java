package org.example;

public class Product extends Menu {
    private double price;

    public Product(String name, double price, String description) {
        super(name, description);
        this.price = price;
    }

    public double getPrice() {
        return price;
    }


}
