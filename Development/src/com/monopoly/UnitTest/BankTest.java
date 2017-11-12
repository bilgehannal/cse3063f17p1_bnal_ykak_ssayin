package com.monopoly.UnitTest;

import com.monopoly.Bank.Bank;
import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Player player = new Player();
    Money money = new Money(Money.Currency.TurkishLira,10000);
    @Test
    void getInstance() {
        assertTrue(Bank.getInstance() == Bank.getInstance());
    }

    @Test
    void pay() {
        double prev = Bank.getInstance().getMoney().getAmount();
        Bank.getInstance().pay(player,money);
        double current = Bank.getInstance().getMoney().getAmount();
        assertEquals(prev - money.getAmount(),current);
    }

    @Test
    void receivePayment() {
        double prev = Bank.getInstance().getMoney().getAmount();
        Bank.getInstance().receivePayment(player,money);
        double current = Bank.getInstance().getMoney().getAmount();
        assertEquals(prev+money.getAmount(),current);
    }

}