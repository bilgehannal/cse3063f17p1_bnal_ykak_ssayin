package com.monopoly.Board.Building;

import com.monopoly.Bank.Money;

public class Building {

    private final double HOUSE_AMOUNT = 200000;
    private final double HOTEL_AMOUNT = 400000;

    private Money priceOfBuilding;

    private BuildingType buildingType;

    public Building(BuildingType buildingType) {
        this.buildingType = buildingType;

        if(buildingType == BuildingType.House) {
            priceOfBuilding = new Money(Money.Currency.TurkishLira,HOUSE_AMOUNT);
        } else {
            priceOfBuilding = new Money(Money.Currency.TurkishLira,HOTEL_AMOUNT);
        }
    }

    public Money getPrice() {
        return priceOfBuilding;
    }

}
