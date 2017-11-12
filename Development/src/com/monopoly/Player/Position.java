package com.monopoly.Player;

public class Position {

    // MARK: Properties
    private int index;

    // MARK: Constructor
    public  Position(int index) {
        this.index = index;
    }

    // MARK: Encapsulation
    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
