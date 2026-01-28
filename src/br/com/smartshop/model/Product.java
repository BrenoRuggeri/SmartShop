package br.com.smartshop.model;

import java.math.BigDecimal;

public class Product {

    private int prodId;
    private String prodName;
    private BigDecimal price;
    private int stock;


    public Product(int prodId, String prodName, BigDecimal price, int stock){
        this.prodId = prodId;
        this.prodName = prodName;
        this.price = price;
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getProdName() {
        return prodName;
    }

    public boolean hasEnoughStock(int quantity) {
        return stock >= quantity;
    }

    public void decreaseStock(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }

        if (quantity > stock) {
            throw new IllegalStateException("Insufficient stock");
        }

        stock -= quantity;
    }



}
