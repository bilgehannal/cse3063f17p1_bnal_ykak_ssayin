package com.monopoly;

public class Money {

    // MARK: Properties
    private String currency;
    private double amount;

    // MARK: Constructors
    public Money(String currency, double amount){
        this.currency = currency;
        this.amount = amount;
    }

    // MARK: Encapsulation
    public String getCurrency() { return this.currency; }

    public void setCurrency(String currency) { this.currency = currency; }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double value) {
        this.amount = value;
    }




    // MARK: Utility Methods

    @Override
    public String toString() {
        return getAmount() + " " + getCurrency();
    }
}
