package com.monopoly;

// Singleton design pattern.
public class Manager {

    // MARK: Properties
    private static Manager sharedManager;
    private Player[] players;
    private Board board;
    private Player winner;

    protected Manager() {

    }

    public static Manager getInstance() {

        if (sharedManager == null) {
            sharedManager = new Manager();
        }
        return sharedManager;
    }

    // MARK: Encapsulation
    public Player[] getPlayers() {
        return this.players;
    }

    public void setPlayers(Player players[]) {
        this.players = players;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    public Player getWinner() {
        return this.winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    // MARK: Utility Methods
    public Position move(Player player,int amount) {
        Position position = new Position(1);
        // TODO: Will be implemented after Block.java by Bilgehan
        return position;
    }

    public void reorderPlayers(Player[] players){
        // TODO: Reordering will be implemented.
    }



}
