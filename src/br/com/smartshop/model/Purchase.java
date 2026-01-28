package br.com.smartshop.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Purchase {

    private Customer customer;
    private Set<PurchaseItem> items;
    private BigDecimal totalAmount;

    public Purchase(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        this.customer = customer;
        this.items = new HashSet<>();
    }

    public void addItem(Product product, int quantity){

        PurchaseItem newItem = new PurchaseItem(product,quantity);

        for(PurchaseItem item : items){
            if(item.equals(newItem)){
                item.addQuantity(quantity);
                return;
            }
        }

        items.add(newItem);
    }

    public void removeItem(Product product, int quantity) {
        if (product == null || quantity <= 0) {
            throw new IllegalArgumentException("Invalid product or quantity");
        }

        PurchaseItem tempItem = new PurchaseItem(product, quantity);

        for (PurchaseItem item : items) {
            if (item.equals(tempItem)) {

                if (item.getQuantity() > quantity) {
                    item.removeQuantity(quantity);
                } else {
                    items.remove(item);
                }
                return;
            }
        }
    }

    public BigDecimal getTotalAmount(){
        BigDecimal total = BigDecimal.ZERO;

        for(PurchaseItem item: items){
            total = total.add(item.getSubTotal());
        }
        return total;
    }

    public boolean hasEnoughBalance() {
        return customer.getBalance()
                .compareTo(getTotalAmount()) >= 0;
    }

    public void checkout() {

        if (items.isEmpty()) {
            throw new IllegalStateException("Purchase has no items");
        }

        for (PurchaseItem item : items) {
            if (!item.hasEnoughStock()) {
                throw new IllegalStateException(
                        "Insufficient stock for product: " + item.getProduct().getProdName()
                );
            }
        }

        if (!hasEnoughBalance()) {
            throw new IllegalStateException("Insufficient balance");
        }

        customer.debit(getTotalAmount());

        for (PurchaseItem item : items) {
            item.getProduct().decreaseStock(item.getQuantity());
        }
    }

    public void printItems() {

        if (items.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        System.out.println("\n=== CART ITEMS ===");

        for (PurchaseItem item : items) {
            Product product = item.getProduct();

            System.out.println(
                    product.getProdName() +
                            " | Quantity: " + item.getQuantity() +
                            " | Unit price: " + product.getPrice() +
                            " | Subtotal: " + item.getSubTotal()
            );
        }

        System.out.println("--------------------");
        System.out.println("Total: " + getTotalAmount());
    }


}
