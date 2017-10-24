package com.monopoly;

public class Area extends Municipality {

    // MARK: Properties

    private String name;
    private Money initialCost;
    private Money rentPrices[];
    private Money prices[];

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

    public void setRentPrices(Money[] rentPrices) {
        this.rentPrices = rentPrices;
    }

    public Money[] getRentPrices() {
        return rentPrices;
    }

    public void setPrices(Money[] prices) {
        this.prices = prices;
    }

    public Money[] getPrices() {
        return prices;
    }
}
