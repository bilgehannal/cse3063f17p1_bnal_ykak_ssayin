package com.monopoly.UnitTest;

import com.monopoly.Bank.Money;
import com.monopoly.Board.Blocks.VisitPrison;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class VisitPrisonTest {
    Money lowPenance = new Money(Money.Currency.TurkishLira,500);
    Money highPenance= new Money(Money.Currency.TurkishLira,50000000);
    VisitPrison prison = new VisitPrison(lowPenance);
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
        player.setInJail(true);
        prison.setPenance(lowPenance);
        prison.interact(player);
        assertTrue(player.getisInJail() == false);
        // Check for not enough money.
        int initialInPrisonTime = player.getInJailTime();
        player.setInJail(true);
        prison.setPenance(highPenance);
        prison.interact(player);
        assertTrue(player.getisInJail() == true);
        assertEquals(initialInPrisonTime+1,player.getInJailTime());
    }

}