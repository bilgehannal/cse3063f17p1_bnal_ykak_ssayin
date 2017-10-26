package com.monopoly.UnitTests;

import com.monopoly.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AreaTest {
    Money money = new Money("Money",100);
    Money money1 = new Money("Money",300);
    Area area = new Area("AreaName",money);
    Player player = new Player();
    ArrayList<Money> rentPrices;
    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void interact1() {

    }
    @Test
    void getTotalRent(){
         /*rentPrices.add(money);
         rentPrices.add(money1);
         area.getRentPrices().add(money1);
         area.getRentPrices().add(money);
         boolean getTotal = area.getTotalRent().getAmount() == 400;
         assertTrue(getTotal);
         */
    }

}