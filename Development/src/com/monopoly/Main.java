package com.monopoly;
import com.monopoly.utilities.PlayerComparator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        initializePlayers();
        System.out.print("\033[H\033[2J");
        determineIterations();
        Manager.getInstance().reorderPlayers(Manager.getInstance().getPlayers());

    }

    //MARK: Utility Functions
    private static void initializePlayers() {
        createMyPlayer();
        createOtherPlayers();
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

    public final static void clearConsole()
    {
        try
        {
            final String os = System.getProperty("os.name");

            if (os.contains("Windows"))
            {
                Runtime.getRuntime().exec("cls");
            }
            else
            {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e)
        {
            //  Handle any exceptions.
        }
    }

}
