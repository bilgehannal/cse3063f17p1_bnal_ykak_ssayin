package com.monopoly;

public class Player {

    private String ID;
    private String username;
    private double currency;
    private Position position;
    //private Area[] ownedAreas;
    //private Card[] ownedCards;

    // Constructor
    public Player(String username) {
        this.username = username;
    }

    // Encapsulation
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getID() { return this.ID; }

    public void setID(String ID) { this.ID = ID; }

    public double getCurrency() {
        return this.currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
