package br.com.smartshop.model;

import java.math.BigDecimal;

public class Customer {

    private String name;
    private String cpf;
    private BigDecimal balance;

    public Customer(String name, String cpf, BigDecimal balance){
        this.name = name;
        this.cpf = cpf;
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void debit(BigDecimal amount) {
        if (amount == null) {
            throw new IllegalArgumentException("Amount cannot be null");
        }

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }

        if (balance.compareTo(amount) < 0) {
            throw new IllegalStateException("Insufficient balance");
        }

        balance = balance.subtract(amount);
    }


}
