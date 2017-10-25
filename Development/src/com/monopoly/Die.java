package com.monopoly;

public class Die {

    // MARK: Properties
    private int faceValue;

    // MARK: Constructors
    public Die(){
        this.faceValue = 1;
    }

    // MARK: Encapsulation
    public int getFaceValue() {
        return this.faceValue;
    }

    public void setFaceValue(int value) {
        this.faceValue = value;
    }

    // MARK: Utility Methods

}