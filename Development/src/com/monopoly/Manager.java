package com.monopoly;
import java.util.Random;

// Singleton design pattern.
public class Manager {

    // MARK: Properties
    private static Manager sharedManager;
    // private Map[] maps;
    private Game currentGame;
    protected Manager() {

    }

    public static Manager getInstance() {

        if (sharedManager == null) {
            sharedManager = new Manager();
        }
        return sharedManager;
    }

    // MARK: Encapsulation
    /*
    public Map[] getMaps() {
        return this.maps;
    }

    public void setMaps(Map[] maps) {
        this.maps = maps;
    }
    */
    public Game getGame() {
        return this.currentGame;
    }

    public void setGame(Game currentGame) {
        this.currentGame = currentGame;
    }

    // MARK: Utility Methods
    public int[] rollDice() {
        int[] diceArray = new int[2];
        Random generator = new Random();

        for (int i = 0; i <diceArray.length ; i++) {
            diceArray[i] = generator.nextInt(6)+1;
        }

        return  diceArray;
    }

    public Position move(Player player,int amount) {
        Position position = new Position(1);
        // TODO: Will be implemented after Block.java by Bilgehan
        return position;
    }



}
