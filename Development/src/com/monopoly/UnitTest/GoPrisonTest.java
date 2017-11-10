package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.monopoly.*;
import static org.junit.jupiter.api.Assertions.*;
class GoPrisonTest {
    Money lowPenance = new Money(Money.Currency.TurkishLira,500);
    Money highPenance= new Money(Money.Currency.TurkishLira,50000000);
    GoPrison prison = new GoPrison(lowPenance);
    Player player = new Player();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void interact() {
        //Check for payment
        prison.setPenance(lowPenance);
        prison.interact(player);
        assertTrue(player.getisInJail() == false);
        // Check for not enough money.
        prison.setPenance(highPenance);
        prison.interact(player);
        assertTrue(player.getisInJail() == true);
    }

}