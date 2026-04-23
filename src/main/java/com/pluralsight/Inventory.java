package com.pluralsight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> products = getInventory();

        int choice;

        do {
            // MENU
            System.out.println("\n1-List  2-Find  3-Add  5-Quit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            // OPTION 1 → list all products
            if (choice == 1) {
                for (Product p : products) {
                    System.out.println(p.getId() + " | " + p.getName() + " | $" + p.getPrice());
                }
            }

            // OPTION 2 → find product by id
            else if (choice == 2) {
                System.out.print("Enter id: ");
                int id = scanner.nextInt();

                for (Product p : products) {
                    if (p.getId() == id) {
                        System.out.println(p.getName() + " - $" + p.getPrice());
                    }
                }
            }

            // OPTION 3 → add new product
            else if (choice == 3) {
                System.out.print("Id: ");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Name: ");
                String name = scanner.nextLine();

                System.out.print("Price: ");
                double price = scanner.nextDouble();

                products.add(new Product(id, name, price));

                // NOTE: only added in memory (not saved to file)
                System.out.println("Added!");
            }

        } while (choice != 5);

        // EXIT
        System.out.println("Bye!");
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

            // READ FILE LINE BY LINE
            while ((line = reader.readLine()) != null) {

                // SPLIT BY |
                String[] parts = line.split("\\|");

                // CREATE PRODUCT OBJECT
                products.add(new Product(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        Double.parseDouble(parts[2])
                ));
            }

            reader.close();

        } catch (Exception e) {
            System.out.println("Error reading file");
        }

        return products;
    }
}