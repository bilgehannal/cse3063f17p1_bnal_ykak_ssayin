package com.monopoly;

import java.util.Currency;

public class Money {

    // MARK: Properties
    private double amount;
    private Currency currency;

    public enum Currency {
        TurkishLira //can be extended according to the needs of further iterations
    }

    // MARK: Constructors
    public Money(Currency currencyType, double amount){
        this.currency = currencyType;
        this.amount = amount;
    }

    // MARK: Encapsulation
    public Currency getCurrency() { return this.currency; }

    public void setCurrency(Currency currency) { this.currency = currency; }

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
