package com.monopoly;

public class Bank {

    // MARK: Properties
    private double currency = 0;
    // private Card[] cards;

    // MARK: Constructors
    public Bank(double currency){
        this.currency = currency;
    }

    public Bank() { };

    // MARK: Encapsulation
    public double getCurrency() {
        return this.currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }
    /*
    public Card[] getCards() {
        return this.cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }
    */

    // MARK: Utility Methods
    public boolean pay(Player player,double amount) {
        if (this.currency > amount) {
            player.addCurrency(amount);
            this.currency -= amount;
            return true;
        }
        return false;
    }

    public boolean receivePayment(Player player,double amount) {
        if (player.pay(amount)){
            this.currency += amount;
            return true;
        }
        return false;
    }

}


