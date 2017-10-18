package com.monopoly;

public class Game {

    // MARK: Properties
    private String ID;
    private Player[] players; //players will be ordered by first rolls of dice.
    //private Map currentMap;
    private Player winner;

    // MARK: Constructor
    public Game(Player[] players) {
        this.players = players;
    }

    // MARK: Encapsulation
    public String getID() {
        return this.ID;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    // TODO: Map Block will be implemented later by Bilgehan.
    /*
    public Map getMap() {
        return this.map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
    */
    // MARK: Utility Methods
    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
