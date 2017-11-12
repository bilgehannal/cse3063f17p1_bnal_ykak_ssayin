package com.monopoly.Bank;

public class Money {

    // MARK: Properties
    private double amount;
    private Currency currency;

    public enum Currency {
        TurkishLira; //can be extended according to the needs of further iterations
        @Override
        public String toString() {
            switch (this) {
                case TurkishLira: return " ₺ " + "(" + this.name() + ")";
                default: return " " + this.name();
            }
        }
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
        return getAmount() + getCurrency().toString();
    }
}
