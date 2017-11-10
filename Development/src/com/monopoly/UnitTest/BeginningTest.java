package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.monopoly.*;
class BeginningTest {
    Player player = new Player();
    Beginning beginningBlock = new Beginning();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void interact() {
        double initialMoney = player.getMoney().getAmount();
        beginningBlock.interact(player);
        assertEquals(initialMoney + 2000000,player.getMoney().getAmount());
    }


}