package com.monopoly;

import java.util.ArrayList;

public class Area extends Block {

    // MARK: Properties

    private String name;
    private ArrayList<Money> rentPrices;
    private ArrayList<Money> prices;
    private Municipality municipality;
    private Deed deed;

    // CONSTRUCTOR

    public Area(String name, Money initialCost) {
        this.name = name;

        rentPrices = new ArrayList<Money>();
        prices = new ArrayList<Money>();

    }

    //MARK: Encapsulation


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRentPrices(ArrayList<Money> rentPrices) {
        this.rentPrices = rentPrices;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public ArrayList<Money> getRentPrices() {
        return rentPrices;
    }

    public void setPrices(ArrayList<Money> prices) {
        this.prices = prices;
    }

    public ArrayList<Money> getPrices() {
        return prices;
    }

    public void setDeed(Deed deed) {
        this.deed = deed;
    }

    public Deed getDeed() {
        return deed;
    }

    // MARK: Utilities

    @Override
    public void interact(Player player) {
        player.pay(getTotalRent());
        System.out.println(getTotalRent().toString() + " is paid to the Bank at " + this.name);
    }

    // getTotalRent calculates the total rent value as a money and returns.
    public Money getTotalRent() {
        double totalAmountOfMoney = 0;
        for (Money rent : rentPrices) {
            totalAmountOfMoney += rent.getAmount();
        }
        return new Money(Money.Currency.TurkishLira,totalAmountOfMoney);
    }


}
