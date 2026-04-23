package com.pluralsight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Inventory {

    public static void main(String[] args) {

        ArrayList<Product> products = getInventory();

        // 🔥 BONUS: sort by name
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));

        // Print inventory
        for (Product p : products) {
            System.out.println(p.getId() + " | " + p.getName() + " | $" + p.getPrice());
        }
    }

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> products = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            Inventory.class.getResourceAsStream("/inventory.csv")
                    )
            );

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);

                products.add(new Product(id, name, price));
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
            e.printStackTrace(); // helps you debug if needed
        }

        return products;
    }
}