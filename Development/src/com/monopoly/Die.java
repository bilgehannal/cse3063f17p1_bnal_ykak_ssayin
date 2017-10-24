package com.monopoly;

public class Die {

    // MARK: Properties
    private int faceValue;

    // MARK: Constructors
    public Die(int value){
        this.faceValue = value;
    }

    // MARK: Encapsulation
    public double getFaceValue() {
        return this.faceValue;
    }

    public void setFaceValue(int value) {
        this.faceValue = value;
    }

    // MARK: Utility Methods

}
