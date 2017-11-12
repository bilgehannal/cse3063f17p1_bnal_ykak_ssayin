package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.monopoly.*;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTaxTest {
    Player player = new Player();
    IncomeTax incomeTax = new IncomeTax();
    @Test
    void payTax() {
        double initialMoney = player.getMoney().getAmount();
        double bankInitial = Bank.getInstance().getMoney().getAmount();
        double taxAmount = initialMoney/10.0;
        incomeTax.payTax(player);
        assertEquals(initialMoney-taxAmount,player.getMoney().getAmount());
        assertEquals(bankInitial+taxAmount,Bank.getInstance().getMoney().getAmount());
    }

}