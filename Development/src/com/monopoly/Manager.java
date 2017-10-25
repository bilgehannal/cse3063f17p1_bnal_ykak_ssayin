package com.monopoly;

import com.monopoly.utilities.PlayerComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

// Singleton design pattern.
public class Manager {

    // MARK: Properties
    private static Manager sharedManager;
    private ArrayList<Player> players;
    private Board board;
    private Player winner;
    private int maxNumberOfIterations;
    private int currentIteration = 0;
    private String nameSet[] = {"Doc","Grumpy","Happy","Sleepy","Dopey","Bashful","Sneezy"};

    protected Manager() {
        // Initialization
        players = new ArrayList<Player>();
    }

    public static Manager getInstance() {

        if (sharedManager == null) {
            sharedManager = new Manager();
        }
        return sharedManager;
    }

    // MARK: Encapsulation
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setNameSet(String[]  nameSet) {
        this.nameSet = nameSet;
    }
    public String getNameFromNameSet() {
        Random generator = new Random();
        String newName;
        boolean shouldContinue;
        do{
            int index = generator.nextInt(nameSet.length);
            newName = nameSet[index];
            shouldContinue = false;
            for (Player player : players) {
                if (player.getUsername().equals(newName)){
                    shouldContinue = true;
                }
            }
        } while(shouldContinue);
        return newName;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMaxNumberOfIterations(int maxNumberOfIterations) {
        this.maxNumberOfIterations = maxNumberOfIterations;
    }

    public int getMaxNumberOfIterations() {
        return maxNumberOfIterations;
    }

    // MARK: Utility Methods
    public void addPlayer(Player player){
        players.add(player);
    }

    public boolean canMoveNextIteration() {
        return currentIteration < maxNumberOfIterations;
    }

    public void moveNextIteration() {
        this.currentIteration++;
    }

    public Position move(Player player,int amount) {
        Position position = new Position(1);
        return position;
    }

    public void reorderPlayers(ArrayList<Player> players){
        for (Player player : players) {
            player.rollDice();
        }
        Collections.sort(players, new PlayerComparator());
        Collections.reverse(players);
    }

    public void printGameInfo(Player player) {

    }

    public void printGameInfo() {

    }

    public void play(Player player) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please press any key to roll the dice");
        sc.nextLine();

        player.rollDice();
        int numberOfBlock = Manager.getInstance().getBoard().getBlocks().size();
        int newPosition = (player.getPosition().getIndex() + player.getTotalDiceValue()) % numberOfBlock;
        player.getPosition().setIndex(newPosition);
        System.out.println(player.getUsername() + " has moved " + player.getTotalDiceValue());

        Block currentBlock = Manager.getInstance().getBoard().getBlocks().get(player.getPosition().getIndex());
        currentBlock.interact(player);

        System.out.println();

    }

}