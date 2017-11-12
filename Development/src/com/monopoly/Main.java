package com.monopoly;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // getting singleton manager instance once.
        Manager manager = Manager.getInstance();

        initializeGame(); //initialize players and board.
        clearConsole();

        determineIterations(); // How many iteration will be done?
        clearConsole();

        manager.reorderPlayers(Manager.getInstance().getPlayers()); // Ordering players
        printPlayerDiceInfo();

        //Iteration Part
        iterateGame();

        showResult();

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
            System.out.println(player.getUsername() + "   Dice: " + player.getDice().get(0).getFaceValue()
                    + " - " + player.getDice().get(1).getFaceValue());
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
    }

    public static void showResult() {
        Player winner = Manager.getInstance().getPlayers().get(0);
        for (Player player : Manager.getInstance().getPlayers()) {
            System.out.println(player.getInfo());
        }
        System.out.println("----------------------\nThe winner of the game\n----------------------\n" + winner.getInfo());
    }

    private static void iterateGame() {
        final long delayTime = 500;
        Manager manager = Manager.getInstance();
        for(int i=0; i<manager.getMaxNumberOfIterations(); i++) {
            for (Player player : manager.getPlayers() ) {
                System.out.println(player.getUsername() + "'s Turn:");
                manager.play(player);
                System.out.println(player.getInfo());

                // There is a delay to check the other players' movement
                try {
                    TimeUnit.MILLISECONDS.sleep(delayTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
