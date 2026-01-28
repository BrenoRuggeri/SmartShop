package br.com.smartshop.app;

import br.com.smartshop.model.*;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Customer customer = null;
        Purchase purchase = null;

        Product notebook = null;
        Product mouse = null;

        int option;

        do {
            System.out.println("\n=== SMARTSHOP MENU ===");
            System.out.println("1 - Create customer");
            System.out.println("2 - Create products");
            System.out.println("3 - Add item to cart");
            System.out.println("4 - Remove item from cart");
            System.out.println("5 - Show cart items");
            System.out.println("6 - Show total");
            System.out.println("7 - Checkout");
            System.out.println("0 - Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (option) {

                    case 1 -> {
                        System.out.print("Customer name: ");
                        String name = scanner.nextLine();

                        System.out.print("CPF: ");
                        String cpf = scanner.nextLine();

                        System.out.print("Initial balance: ");
                        BigDecimal balance = scanner.nextBigDecimal();

                        customer = new Customer(name, cpf, balance);
                        purchase = new Purchase(customer);

                        System.out.println("Customer created successfully!");
                    }

                    case 2 -> {
                        notebook = new Product(
                                1,
                                "Notebook",
                                new BigDecimal("250.00"),
                                5
                        );

                        mouse = new Product(
                                2,
                                "Mouse",
                                new BigDecimal("50.00"),
                                10
                        );

                        System.out.println("Products created!");
                    }

                    case 3 -> {
                        if (purchase == null) {
                            System.out.println("Create a customer first.");
                            break;
                        }

                        System.out.println("Choose product:");
                        System.out.println("1 - Notebook");
                        System.out.println("2 - Mouse");

                        int productOption = scanner.nextInt();

                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();

                        if (productOption == 1) {
                            purchase.addItem(notebook, quantity);
                        } else if (productOption == 2) {
                            purchase.addItem(mouse, quantity);
                        }

                        System.out.println("Item added to cart!");
                    }

                    case 4 -> {
                        if (purchase == null) {
                            System.out.println("Cart is empty.");
                            break;
                        }

                        System.out.println("Choose product to remove:");
                        System.out.println("1 - Notebook");
                        System.out.println("2 - Mouse");

                        int productOption = scanner.nextInt();

                        System.out.print("Quantity: ");
                        int quantity = scanner.nextInt();

                        if (productOption == 1) {
                            purchase.removeItem(notebook, quantity);
                        } else if (productOption == 2) {
                            purchase.removeItem(mouse, quantity);
                        }

                        System.out.println("Item removed from cart!");
                    }

                    case 5 -> {
                        purchase.printItems();
                    }

                    case 6 -> {
                        System.out.println("Total amount: " + purchase.getTotalAmount());
                    }

                    case 7 -> {
                        purchase.checkout();
                        System.out.println("Purchase completed successfully!");
                        System.out.println("Remaining balance: " + customer.getBalance());
                    }

                    case 0 -> System.out.println("Exiting SmartShop...");

                    default -> System.out.println("Invalid option");
                }

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (option != 0);

        scanner.close();
    }
}
