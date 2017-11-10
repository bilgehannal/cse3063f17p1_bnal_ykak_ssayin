package com.monopoly.UnitTest;

import com.monopoly.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AreaTest {
    Money price = new Money(Money.Currency.TurkishLira,100000);
    Money rentPrice = new Money(Money.Currency.TurkishLira,10000);
    Deed noOwnerDeed = new Deed(price,rentPrice);
    Deed deed = new Deed(price,rentPrice);
    Area area = new Area("Area",deed);
    //Area emptyArea = new Area("Empty Area",noOwnerDeed);
    Player player = new Player();
    Player player2 = new Player();
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void interact() {
        // Testing for renting system
        double initialMoney = player.getMoney().getAmount();
        deed.setOwner(player);
        area.interact(player2);
        assertTrue(initialMoney-deed.getRentPrice().getAmount() == player2.getMoney().getAmount());
        // Testing for rentExemption conditon
        double secondaryMoney = player2.getMoney().getAmount();
        player2.setHasRentExemption(true);
        area.interact(player2);
        assertTrue(secondaryMoney == player2.getMoney().getAmount());
    }
    @Test
    void getTotalRent(){
        double rentPriceAmount = rentPrice.getAmount();
        assertEquals(rentPriceAmount,area.getTotalRent().getAmount());
    }

}