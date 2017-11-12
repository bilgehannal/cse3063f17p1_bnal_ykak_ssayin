package com.monopoly.Manager;

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
        if (value>=1 && value<=6)
        this.faceValue = value;
    }


}
