package org.example;

import org.example.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable {
    private List<Product> cart;
    private String        message;

    private LocalDateTime orderTime;

    public Order() {
        cart = new ArrayList<>();
        orderTime = LocalDateTime.now();
    }

    public void setCart(List<Product> cart, String message) {
        this.cart = cart;
        this.message = message;
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

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public String getMessage() {
        return message;
    }
}
