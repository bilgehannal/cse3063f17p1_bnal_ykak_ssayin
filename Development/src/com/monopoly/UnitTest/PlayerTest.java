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
        player.addMoney(money);
        assertEquals(800,player.getMoney().getAmount());
    }

    @Test
    void pay() {
      boolean pay =  player.pay(money) && player.getMoney().getAmount() >money.getAmount();
        assertTrue(pay);
    }
    @Test
    void pay1() {
        boolean pay1 = player.pay(player2,money) && player2.getMoney().getAmount() == 800;
        assertTrue(pay1);
    }

    @Test
    void rollDice() {
        player.rollDice();
        boolean interval = 0 < player.getTotalDiceValue() || player.getTotalDiceValue()>=12;
        assertTrue(interval);
    }

    @Test
    void getTotalDiceValue() {
        dice.setFaceValue(3);
        dice1.setFaceValue(6);
        diceArray[0]=dice;
        diceArray[1]=dice1;
        player.getDice().add(diceArray[0]);
        player.getDice().add(diceArray[1]);
        assertEquals(9,player.getTotalDiceValue());

    }

}