package com.monopoly.Board.Blocks;

import com.monopoly.Board.Blocks.Area;

import java.util.ArrayList;

public class Municipality {

    // MARK: Properties

    private String municipalityName;
    private ArrayList<Area> areas;

    // MARK: CONSTRUCTOR

    public Municipality(String municipalityName) {
        this.municipalityName = municipalityName;
        areas = new ArrayList<Area>();
    }

    // MARK: Encapsulation


    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void addArea(Area area) {
        areas.add(area);
        area.setMunicipality(this);
    }
}
