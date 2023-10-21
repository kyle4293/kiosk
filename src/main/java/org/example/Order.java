package org.example;

import org.example.Product;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> cart;

    public Order() {
        cart = new ArrayList<>();
    }

    public void addCart(Product product) {
        cart.add(product);
    }

    public List<Product> getCart() {
        return cart;
    }

    public void clearCart() {
        cart.clear();
    }
}
