package com.monopoly;

public abstract class Block {

    // MARK: Properties

    private String ID;
    private Position position;
    // MARK: Encapsulation


    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }

    public abstract void interact(Player player);
}
