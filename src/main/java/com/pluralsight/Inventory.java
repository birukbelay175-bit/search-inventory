package com.pluralsight;

import java.util.ArrayList;

 public class Inventory {

    public static void main(String[] args) {

        ArrayList<Product> products = getInventory();

        // Print inventory
        for (Product p : products) {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product("Laptop", 800));
        products.add(new Product("Phone", 500));
        products.add(new Product("Tablet", 300));
        products.add(new Product("Headphones", 100));
        products.add(new Product("Keyboard", 50));

        return products;
    }
}