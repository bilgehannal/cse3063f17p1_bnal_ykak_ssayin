package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.monopoly.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Money money = new Money(Money.Currency.TurkishLira,100);
    Player player = new Player();
    Player player2 = new Player();
    Die dice = new Die();
    Die dice1 = new Die();
    Die diceArray[] = new Die[2];
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

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
        boolean interval2 = 0 < player.getTotalDiceValue() || player.getTotalDiceValue()>=12;
        assertTrue(interval2);
    }

    @Test
    void getTotalDiceValue() {
        dice.setFaceValue(3);
        dice1.setFaceValue(6);
        diceArray[0]=dice;
        diceArray[1]=dice1;
        player.getDice().add(diceArray[0]);
        player.getDice().add(diceArray[1]);
        assertEquals(dice.getFaceValue()+dice1.getFaceValue(),player.getTotalDiceValue());

    }

}