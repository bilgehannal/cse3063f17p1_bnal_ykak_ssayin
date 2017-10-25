package com.monopoly;
import com.monopoly.utilities.PlayerComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializeGame();
        clearConsole();

        determineIterations();
        clearConsole();

        Manager.getInstance().reorderPlayers(Manager.getInstance().getPlayers());
        printPlayerDiceInfo();

        for(int i=0; i<Manager.getInstance().getMaxNumberOfIterations(); i++) {
            for (Player player : Manager.getInstance().getPlayers() ) {
                Manager.getInstance().play(player);
            }
        }


    }

    //MARK: Utility Functions
    private static void initializeGame() {
        createMyPlayer();
        createOtherPlayers();
        Manager.getInstance().setBoard(new Board());
    }

    private static void createMyPlayer() {
        System.out.println("Welcome to Monopoly! Who is this?");
        Player myPlayer = new Player(sc.nextLine());
        Manager.getInstance().addPlayer(myPlayer);
    }

    private static void createOtherPlayers() {
        int numberOfPlayers = -1;
        do {
            System.out.println("How many players would you like to play with? \nENTER PLAYER NUMBER EXCEPT YOU (1..7) :");
            try {
                numberOfPlayers = Integer.parseInt(sc.nextLine());
            }catch(Exception e) {
                System.err.println("Invalid input.");
                System.err.println(e.getLocalizedMessage());
            }
        }while(numberOfPlayers < 1 || numberOfPlayers > 7);

        for (int i = 0; i < numberOfPlayers; i++) {
            Player newPlayer =  new Player();
            Manager.getInstance().addPlayer(newPlayer);
        }
    }

    private static void determineIterations() {
        boolean shouldContinue;
        do {
            shouldContinue = false;
            System.out.println("Would you like to determine a maximum number of iterations? " +
                    "\nIf so, the richest player will win the game at the end of those iterations. (y / n)");
            String choice = sc.nextLine().toLowerCase();
            switch (choice) {
                case "y":
                    handleSettingIterations();
                    break;
                case "n":
                    System.err.println("This part will be done in next iterations.");
                    System.exit(0);
                    break;
                default:
                    shouldContinue = true;
                    break;
            }
        }while (shouldContinue);
    }

    private static void handleSettingIterations() {
        int numberOfIteration;
        do {
            numberOfIteration = 0;
            System.out.println("ENTER NUMBER OF ITERATION:");
            try {
                numberOfIteration = Integer.parseInt(sc.nextLine());
            }catch(Exception e) {
                System.err.println("Invalid input.");
                System.err.println(e.getLocalizedMessage());
            }

        }while(numberOfIteration > 100 || numberOfIteration < 1 );

        Manager.getInstance().setMaxNumberOfIterations(numberOfIteration);
    }

    private static void printPlayerDiceInfo() {
        System.out.println("Order of Players: ");
        for (Player player : Manager.getInstance().getPlayers()) {
            System.out.println(player.getUsername() + "   Dice: " + player.getDice()[0].getFaceValue() + " - " + player.getDice()[1].getFaceValue());
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

}
