package com.monopoly.UnitTest;

import com.monopoly.Board.Blocks.FreeParking;
import com.monopoly.Player.Player;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FreeParkingTest {
    Player player = new Player();
    FreeParking freeParking = new FreeParking();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void interact() {
        freeParking.interact(player);
        assertTrue(player.getHasRentExemption() == true);
    }

}