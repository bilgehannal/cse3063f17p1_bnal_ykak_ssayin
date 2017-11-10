package com.monopoly.UnitTest;

import com.monopoly.Municipality;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.monopoly.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MunicipalityTest {
    private Money price = new Money(Money.Currency.TurkishLira,1000000);
    private Money rentPrice = new Money(Money.Currency.TurkishLira,10000);
    private Municipality mun = new Municipality("MuName");
    private Deed deed  = new Deed(price,rentPrice);
    private Area area1 = new Area("TestArea1",deed);
    private Area area2 = new Area("TestArea2",deed);
    private ArrayList<Area>areas = new ArrayList<Area>();
    @BeforeEach
    void setUp() {
    }
    @AfterEach
    void tearDown() {
    }
    @Test
    void addArea(){
    }

}