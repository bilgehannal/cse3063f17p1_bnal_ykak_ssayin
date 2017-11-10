package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.monopoly.*;
class PrisonTest {
    Money money = new Money(Money.Currency.TurkishLira,300);
    Prison prison = new Prison(money);
    Player player = new Player();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setPenance() {
    }

    @Test
    void getPenance() {
    }

    @Test
    void interact() {
    }

    @Test
    void setID() {
    }

    @Test
    void getID() {
    }

    @Test
    void interact1() {
        prison.interact(player);
    }

}