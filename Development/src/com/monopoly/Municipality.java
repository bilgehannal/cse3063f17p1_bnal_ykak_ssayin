package com.monopoly;

public class Municipality extends Block {

    // MARK: Properties

    private String municipalityName;
    private int numberOfAreas;

    // MARK: Encapsulation


    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setNumberOfAreas(int numberOfAreas) {
        this.numberOfAreas = numberOfAreas;
    }

    public int getNumberOfAreas() {
        return numberOfAreas;
    }
}
