package com.monopoly.UnitTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.monopoly.*;
class GoPrisonTest {
    Money money = new Money("Monopoly Money",300);
    GoPrison prison = new GoPrison(money);
    Player player = new Player();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setPenance() {
    }

    @Test
    void getPenance() {
    }

    @Test
    void interact() {
    }

    @Test
    void setID() {
    }

    @Test
    void getID() {
    }

    @Test
    void interact1() {
        prison.interact(player);
    }

}