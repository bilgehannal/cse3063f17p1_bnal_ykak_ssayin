package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.monopoly.*;

import static org.junit.jupiter.api.Assertions.*;

class IncomeTaxTest {
    Player player = new Player();
    Money taxMoney = new Money(Money.Currency.TurkishLira,20000);
    IncomeTax incomeTax = new IncomeTax();
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
        double taxAmount = initialMoney/10.0;
        incomeTax.payTax(player);
        assertEquals(initialMoney-taxAmount,player.getMoney().getAmount());
        assertEquals(bankInitial+taxAmount,Bank.getInstance().getMoney().getAmount());
    }

}