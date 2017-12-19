package com.monopoly.Board.Blocks;

import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;
import com.monopoly.Bank.Deed;

// Since internal details of ElectricityUtility, WaterUtility and Railroad blocks are 100% same,
// they are all called UtilityAreas.

public class UtilityArea extends Area {

    public UtilityArea(String name, Deed deed) {
        super(name,deed);
        super.setBuildable(false);
    }

    @Override
    public void interact(Player player) {
        super.getDeed().getRentPrices()[0] = (new Money(Money.Currency.TurkishLira,player.getTotalDiceValue() * 10000));
        super.interact(player);
    }
}
