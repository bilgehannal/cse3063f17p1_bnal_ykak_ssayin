package com.monopoly.UnitTest;

import com.monopoly.Bank.Deed;
import com.monopoly.Bank.Money;
import com.monopoly.Board.Blocks.Area;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AreaTest {
    /*
    Money price = new Money(Money.Currency.TurkishLira,100);
    Money rentPrice = new Money(Money.Currency.TurkishLira,10);
    Deed deed = new Deed(price,rentPrice);
    Area area = new Area("Area",deed);
    Player player = new Player();
    Player player2 = new Player();
    @org.junit.jupiter.api.Test
    void interact() {
        // Testing for renting system
        double initialMoney = player.getMoney().getAmount();
        deed.setOwner(player);
        area.interact(player2);
        assertTrue(initialMoney-deed.getRentPrice().getAmount() == player2.getMoney().getAmount());
        // Testing for rentExemption conditon
         initialMoney = player2.getMoney().getAmount();
        player2.setHasRentExemption(true);
        area.interact(player2);
        assertTrue(initialMoney == player2.getMoney().getAmount());
        // Testing for purchasing area
        area.getDeed().setOwner(null);
        area.interact(player);
        assertTrue(area.getDeed().getOwner() == player);
    }
    @Test
    void getTotalRent(){
        double rentPriceAmount = rentPrice.getAmount();
        assertEquals(rentPriceAmount,area.getTotalRent().getAmount());
    }
*/
}