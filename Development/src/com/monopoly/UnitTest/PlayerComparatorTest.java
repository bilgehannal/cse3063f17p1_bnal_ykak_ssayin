package com.monopoly.UnitTest;

import com.monopoly.Manager.Die;
import com.monopoly.Player.Player;
import com.monopoly.utilities.PlayerComparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerComparatorTest {
    PlayerComparator comp = new PlayerComparator();
    Player player1 = new Player();
    Player player2 = new Player();
    Die dice[] = new Die[2];
    Die die1 = new Die();
    Die die2 = new Die();
    Die dice1[] = new Die[2];
    Die die11 = new Die();
    Die die22 = new Die();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void compare() {
        die1.setFaceValue(4);
        die2.setFaceValue(5);
        dice[0] = die1;
        dice[1] = die2;
        player1.getDice().add(die1);
        player1.getDice().add(die2);
        die11.setFaceValue(4);
        die22.setFaceValue(5);
        dice1[0] = die11;
        dice1[1] = die22;
        player2.getDice().add(dice1[0]);
        player2.getDice().add(dice[1]);

       boolean equals = player1.getTotalDiceValue() == player2.getTotalDiceValue();

       boolean success = comp.compare(player1,player2) == 0 && equals;
       assertTrue(success);
    }

}