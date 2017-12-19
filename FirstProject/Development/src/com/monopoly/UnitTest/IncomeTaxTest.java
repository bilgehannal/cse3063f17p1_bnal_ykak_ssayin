package com.monopoly.UnitTest;

import com.monopoly.Bank.Bank;
import com.monopoly.Board.Blocks.IncomeTax;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.Test;

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