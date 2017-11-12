package com.monopoly.Bank;

import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;

public class Deed{

    private Money price;
    private Money rentPrice;
    private Player owner;

    // MARK: Constructer

    public Deed(Money price, Money rentPrice) {
        this.price = price;
        this.rentPrice = rentPrice;
        owner = null;
    }

    // MARK: Encapsulation

    public void setPrice(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    public void setRentPrice(Money rentPrice) {
        this.rentPrice = rentPrice;
    }

    public Money getRentPrice() {
        return rentPrice;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
