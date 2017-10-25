package com.monopoly;

public abstract class Block {

    // MARK: Properties

    private String ID;

    // MARK: Encapsulation


    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public abstract void interact(Player player);
}
