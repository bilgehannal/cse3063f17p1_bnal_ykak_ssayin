package com.monopoly.Bank;

import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;

public class Deed{

    private Money price;
    private Money[] rentPrices; // Keeps the rent prices according to the owned building
    private Player owner;

    // MARK: Constructor

    public Deed(Money price, Money rentPrice0, Money rentPrice1, Money rentPrice2, Money rentPrice3, Money rentPrice4) {
        this.price = price;
        this.rentPrices = new Money[5];
        this.rentPrices[0] = rentPrice0; // Not have house
        this.rentPrices[1] = rentPrice1; // Having one house
        this.rentPrices[2] = rentPrice2; // Having two houses
        this.rentPrices[3] = rentPrice3; // Having three houses
        this.rentPrices[4] = rentPrice4; // Having a hotel
        owner = null;
    }

    // This constructer for the utility area
    public Deed(Money price, Money rentPrice0) {
        this.price = price;
        this.rentPrices = new Money[5];
        this.rentPrices[0] = rentPrice0; // Not have house
        owner = null;
    }

    // MARK: Encapsulation

    public void setPrice(Money price) {
        this.price = price;
    }

    public Money getPrice() {
        return price;
    }

    public void setRentPrice(Money[] rentPrices) {
        this.rentPrices = rentPrices;
    }

    public Money[] getRentPrices() {
        return rentPrices;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
