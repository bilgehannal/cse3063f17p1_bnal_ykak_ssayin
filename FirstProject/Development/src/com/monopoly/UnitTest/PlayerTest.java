package com.monopoly.UnitTest;

import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Money money = new Money(Money.Currency.TurkishLira,100);
    Player player = new Player();
    Player player2 = new Player();
    @Test
    void addMoney() {
        double initialMoney = player.getMoney().getAmount();
        player.addMoney(money);
        assertEquals(initialMoney + money.getAmount(),player.getMoney().getAmount());
    }

    @Test
    void pay() {
        double initialMoney = player.getMoney().getAmount();
        player.pay(money);
        assertEquals(initialMoney-money.getAmount(),player.getMoney().getAmount());
    }
    @Test
    void pay1() {
        double initialMoneyPlayer1 = player.getMoney().getAmount();
        double initialMoneyPlayer2 = player.getMoney().getAmount();
        player.pay(player2,money);
        assertEquals(initialMoneyPlayer1-money.getAmount(),player.getMoney().getAmount());
        assertEquals(initialMoneyPlayer2+money.getAmount(),player2.getMoney().getAmount());
    }

    @Test
    void rollDice() {
        // We need to check for each faceValue too.
        player.rollDice();
        int faceValue = player.getDice().get(1).getFaceValue();
        assertTrue(faceValue>=1 && faceValue<=6);
    }

    @Test
    void getTotalDiceValue() {
        player2.rollDice();
        int totalValue = player2.getDice().get(1).getFaceValue() + player2.getDice().get(0).getFaceValue();
        assertEquals(totalValue,player2.getTotalDiceValue());

    }

}