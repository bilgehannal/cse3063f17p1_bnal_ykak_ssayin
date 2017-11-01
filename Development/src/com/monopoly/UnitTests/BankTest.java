package com.monopoly.UnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.monopoly.*;

class BankTest {
    Player player = new Player();
    Money money = new Money("Monopoly Money",300);
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
    }

    @Test
    void pay() {
        /*double prev = player.getMoney().getAmount();
        Bank.getInstance().pay(player,money);
        double current = player.getMoney().getAmount();
        assertEquals(prev,current);*/
    }

    @Test
    void receivePayment() {
       /*double prev = Bank.getInstance().getMoney().getAmount();
        Bank.getInstance().receivePayment(player,money);
        double current = Bank.getInstance().getMoney().getAmount();
        boolean success = current -prev == 300;
        */
    }

}