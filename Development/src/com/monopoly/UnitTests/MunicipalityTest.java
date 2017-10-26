package com.monopoly.UnitTests;

import com.monopoly.Area;
import com.monopoly.Municipality;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import com.monopoly.*;
class MunicipalityTest {
    Money money = new Money("Dolar ",300);
    Municipality mun = new Municipality("MuName");
    Municipality mun1 = new Municipality("MuName");
    Area area = new Area("Name",money);
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void setMunicipalityName() {
    }

    @Test
    void getMunicipalityName() {
    }

    @Test
    void setNumberOfAreas() {
    }

    @Test
    void getNumberOfAreas() {
    }

    @Test
    void setID() {
    }

    @Test
    void getID() {
    }

    @Test
    void interact() {
    }
    @Test
    void addArea(){
        mun1.getAreas().add(area);
        mun.addArea(area);
        assertEquals(mun.getAreas(),mun1.getAreas());

    }

}