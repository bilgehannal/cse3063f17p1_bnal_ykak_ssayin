package com.monopoly;

import java.util.ArrayList;

public class Area extends Municipality {

    // MARK: Properties

    private String name;
    private Money initialCost;
    private ArrayList<Money> rentPrices;
    private ArrayList<Money> prices;

    // CONSTRUCTOR

    public Area(String name, Money initialCost) {
        this.name = name;
        this.initialCost = getInitialCost();

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

    public void setInitialCost(Money initialCost) {
        this.initialCost = initialCost;
    }

    public Money getInitialCost() {
        return initialCost;
    }

    public void setRentPrices(ArrayList<Money> rentPrices) {
        this.rentPrices = rentPrices;
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

    // MARK: Utilities

    @Override
    public void interact(Player player) {
        player.pay(getTotalRent());
        System.out.println(getTotalRent().getAmount() + " monopoly money is paid to the Bank at " + this.name);
    }

    public Money getTotalRent() {
        Money money = new Money("Monopoly Money", 0);
        for (Money rent : rentPrices) {
            money.addAmount(rent);
        }
        return money;
    }


}
