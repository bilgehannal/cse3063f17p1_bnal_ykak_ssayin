package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.monopoly.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DieTest {
    Die die = new Die();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void setFaceValue(){
        // If somehow setFaceValue gets a parameter out of bound it will remain initial value.
        int initialFaceValue = die.getFaceValue();
        die.setFaceValue(-30);
        assertEquals(initialFaceValue,die.getFaceValue());
    }

}