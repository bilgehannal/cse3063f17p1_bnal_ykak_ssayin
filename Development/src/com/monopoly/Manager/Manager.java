package com.monopoly.Manager;

import com.monopoly.Bank.Bank;
import com.monopoly.Board.Blocks.Block;
import com.monopoly.Board.Blocks.VisitPrison;
import com.monopoly.Board.Board;
import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;
import com.monopoly.Player.Position;
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
    private Position prisonPosition;

    // MARK: Constants
    private final double moneyAmountPerTurnOfBoard = 2000000;

    protected Manager() {
        // Initialization
        players = new ArrayList<>();
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

    public void setCurrentIteration(int currentIteration) {
        this.currentIteration = currentIteration;
    }

    public int getCurrentIteration() {
        return currentIteration;
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

    public String getMoneyAmountPerTurnOfBoard() {
        return new Money(Money.Currency.TurkishLira,this.moneyAmountPerTurnOfBoard).toString();
    }

    public void setPrisonPosition(Position prisonPosition) {
        this.prisonPosition = prisonPosition;
    }

    public Position getPrisonPosition() {
        return prisonPosition;
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

    public void reorderPlayers(ArrayList<Player> players){
        for (Player player : players) {
            player.rollDice();
        }
        Collections.sort(players, new PlayerComparator());
        Collections.reverse(players);
    }

    public boolean play(Player player) {
        if (!player.getisInJail()) {
            handleIfPlayerIsNotInPrison(player);
        }
        else{
            VisitPrison.handleIfPlayerInPrison(player);
        }
        return Manager.getInstance().checkForDouble(player);
    }

    public void sendPrison(Player player) {
        player.setPosition(prisonPosition);
        System.out.println(player.getUsername() + " is now in prison!");
    }

    private int updatePositionOf(Player player) {
        int numberOfBlock = getBoard().getBlocks().size();
        int newPositionIndex = (player.getPosition().getIndex() + player.getTotalDiceValue()) % numberOfBlock;
        int previousPositionIndex = player.getPosition().getIndex();

        // Handle paying money at each turn of the board
        if (newPositionIndex < previousPositionIndex) {
            Money money = new Money(Money.Currency.TurkishLira,moneyAmountPerTurnOfBoard);
            Bank.getInstance().pay(player,money);
            System.out.println(money.toString() + " is paid to " + player.getUsername()
                    + " since s/he has completed a turn in board.");
        }

        player.getPosition().setIndex(newPositionIndex);
        return newPositionIndex;
    }

    public boolean checkForDouble(Player player){
        int firstValue = player.getDice().get(0).getFaceValue();
        int secondValue = player.getDice().get(1).getFaceValue();
        if (firstValue == secondValue){
            return true;
        }
        return false;
    }

    public boolean isDoublesThree(Player player){
        for (boolean value:player.getLastThreeDoubles()) {
            if (value == false)
                return false;
        }
        return true;
    }

    private void handleIfPlayerIsNotInPrison(Player player) {
        Scanner sc = new Scanner(System.in);
        if (!player.isAutoPlay()) {
            System.out.println("Please press any key to roll the dice");
            sc.nextLine();
        } else {
            System.out.println("Dice are rolled");
        }
        player.rollDice();
        if (isDoublesThree(player)){
            player.setInJail(true);
            Manager.getInstance().sendPrison(player);
        }
        else {
            int newPosition = updatePositionOf(player);

            Block currentBlock = getBoard().getBlocks().get(player.getPosition().getIndex());
            System.out.println(player.getUsername() + " has moved " + player.getTotalDiceValue());
            System.out.println("Index of Block: " + newPosition);

            currentBlock.interact(player);

            System.out.println();
        }
    }


}