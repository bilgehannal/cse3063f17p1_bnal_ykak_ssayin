package com.monopoly.UnitTest;

import com.monopoly.Bank.Bank;
import com.monopoly.Board.Blocks.LuxuryTax;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LuxuryTaxTest {
    Player player = new Player();
    LuxuryTax luxuryTax = new LuxuryTax();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void payTax() {
        double initialMoney = player.getMoney().getAmount();
        double bankInitial = Bank.getInstance().getMoney().getAmount();
        double taxAmount = 75;
        luxuryTax.payTax(player);
        assertEquals(initialMoney-taxAmount,player.getMoney().getAmount());
        assertEquals(bankInitial+taxAmount,Bank.getInstance().getMoney().getAmount());
    }


}