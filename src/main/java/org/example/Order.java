package org.example;

import org.example.Product;

import java.util.ArrayList;
import java.util.List;

public class Order implements Cloneable{
    private List<Product> cart;

    public Order() {
        cart = new ArrayList<>();
    }

    public void setCart(List<Product> cart) {
        this.cart = cart;
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
