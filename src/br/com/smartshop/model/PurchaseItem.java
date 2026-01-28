package br.com.smartshop.model;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.Objects;

public class PurchaseItem {

    private Product product;
    private int quantity;

    public PurchaseItem(Product product, int quantity){
        if(product == null){
            throw new IllegalArgumentException("Product cannot be null");
        } else if (quantity <=0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        this.product = product;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseItem that = (PurchaseItem) o;
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(product);
    }

    public void addQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        this.quantity += quantity;
    }

    public void removeQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (quantity > this.quantity) {
            throw new IllegalArgumentException("Cannot remove more than existing quantity");
        }

        this.quantity -= quantity;
    }

    public BigDecimal getSubTotal(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

    public boolean hasEnoughStock(){
        return product.hasEnoughStock(quantity);
    }


}
