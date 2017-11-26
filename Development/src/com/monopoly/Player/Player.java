package com.monopoly.Player;
import com.monopoly.Board.Blocks.Area;
import com.monopoly.Board.Building.Building;
import com.monopoly.Manager.Die;
import com.monopoly.Manager.Manager;
import com.monopoly.Bank.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Player {

    // MARK: Properties
    private String ID;
    private String username;
    private Position position;
    private Money money;
    private ArrayList<Area> ownedAreas;
    private ArrayList<Die> dice;
    boolean[] lastThreeDoubles = new boolean[3];
    private boolean autoPlay;
    private boolean inJail;
    private boolean hasRentExemption;
    private int inJailTime;
    private boolean isBankrupt;
    private int doublesCounter;
    // MARK: Constants
    private final double initialMoney = 2000000;

    // MARK: Constructor
    public Player(String username) {
        this();
        position = new Position(0);
        this.username = username;
        this.autoPlay = false;
    }

    public Player() {
        String name = Manager.getInstance().getNameFromNameSet();
        this.username = name;
        dice = new ArrayList<Die>();
        diceInitialize();
        position = new Position(0);
        money = new Money(Money.Currency.TurkishLira,initialMoney);
        this.autoPlay = true;
        this.inJail = false;
        this.inJailTime = 0;
        this.hasRentExemption = false;
        this.isBankrupt = false;
        this.doublesCounter = 0;
        Arrays.fill(this.lastThreeDoubles, Boolean.FALSE);
        ownedAreas = new ArrayList<Area>();
    }

    // MARK: Encapsulation
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getID() { return this.ID; }

    public void setID(String ID) { this.ID = ID; }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Money getMoney() { return this.money; }

    public void setMoney(Money money) { this.money = money; }

    public ArrayList<Area> getOwnedAreas() { return this.ownedAreas; }

    public void setOwnedAreas(ArrayList<Area> ownedAreas) { this.ownedAreas = ownedAreas; }

    public ArrayList<Die> getDice() { return this.dice; }

    public void setDice(ArrayList<Die> dice) { this.dice = dice; }

    public void setAutoPlay(boolean autoPlay) {
        this.autoPlay = autoPlay;
    }

    public boolean isAutoPlay() {
        return autoPlay;
    }

    public boolean getisInJail() {
        return inJail;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getInJailTime() {
        return inJailTime;
    }

    public void setInJailTime(int inJailTime) {
        this.inJailTime = inJailTime;
    }

    public boolean getHasRentExemption() {
        return this.hasRentExemption;
    }

    public void setHasRentExemption(boolean hasRentExemption) {
        this.hasRentExemption = hasRentExemption;
    }

    public boolean isBankrupt() {
        return isBankrupt;
    }

    public void setDoublesCounter(int doublesCounter) {
        this.doublesCounter = doublesCounter;
    }

    public int getDoublesCounter() {
        return doublesCounter;
    }

    public void setLastThreeDoubles(boolean[] lasThreeDoubles) {
        this.lastThreeDoubles = lasThreeDoubles;
    }

    public boolean[] getLastThreeDoubles() {
        return lastThreeDoubles;
    }

    public void setBankrupt(boolean bankrupt) {
        if(bankrupt) {
            getMoney().setAmount(0); // When the player is bankrupted then s/he has 0 money.
        }
        isBankrupt = bankrupt;
    }

    // MARK: Utility Methods
    public void addMoney(Money money) {
        double newAmount = this.money.getAmount() + money.getAmount();
        this.money.setAmount(newAmount);
    }

    // Pay methods to player and bank

    public boolean canPay(Money money){
        if (this.money.getAmount() >= money.getAmount()) {
            return true;
        }
        return false;
    }


    public boolean pay(Money money){
        if (canPay(money)){
            double newAmount = this.money.getAmount() - money.getAmount();
            this.money.setAmount(newAmount);
            return true;
        }
        return false;
    }

    public boolean pay(Player player, Money money) {

        if(canPay(money) && player != this) {
            player.getMoney().setAmount(player.getMoney().getAmount() + money.getAmount());
            this.money.setAmount(this.money.getAmount() - money.getAmount());
            return true;
        }
        return false;
    }


    // Dice methods

    public void rollDice() {
        System.out.println("Dice values: " + dice.get(0).getFaceValue() + " - "
                + dice.get(1).getFaceValue());
        rotateDoublesArray(Manager.getInstance().checkForDouble(this));

        Random generator = new Random();

        for (int i = 0; i <dice.size() ; i++) {
            rollDie(dice.get(i));
        }

        Manager.getInstance().checkForDouble(this);
    }

    public void rollDie(Die die) {
        Random generator = new Random();
        int newFaceValue = generator.nextInt(6)+1;
        die.setFaceValue(newFaceValue);
    }

    public void rotateDoublesArray(boolean value){
        for (int i = 0; i <this.lastThreeDoubles.length-1 ; i++) {
            this.lastThreeDoubles[i] = this.lastThreeDoubles[i+1];
        }
        this.lastThreeDoubles[lastThreeDoubles.length-1] = value;
    }

    public int getTotalDiceValue() {
        int sum = 0;
        for (Die die : dice) {
            sum += die.getFaceValue();
        }
        return sum;
    }

    private void diceInitialize() {
        dice.add(new Die());
        dice.add(new Die());
    }

    // Decisions

    public boolean wantToBuyArea(Area area) {
        // If the player doesn't have enough money return false
        if(this.getMoney().getAmount() < area.getDeed().getPrice().getAmount()) {
            return false;
        }
        // AI and real player control to buy the area
        if(this.isAutoPlay()) {
            boolean randomSelection = Math.random() < 0.5 ? true : false;
            return randomSelection; // If rolled dice are greater than 4, then buy.
        } else {
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println("Do you want to buy " + area.getName() + " : y/n");
                String decision = sc.nextLine().toLowerCase();
                if(decision.equals("y")) {
                    return true;
                } else if(decision.equals("n")) {
                    return false;
                }
                System.out.println("Wrong input, please enter y or n");
            }
        }

    }

    public boolean wantToBuildNewBuilding(Building building) {
        // AI and real player control to build a new building
        if(this.isAutoPlay()) {
            boolean randomSelection = Math.random() < 0.5 ? true : false;
            return randomSelection; // If rolled dice are greater than 4, then buy.
        } else {
            Scanner sc = new Scanner(System.in);
            while(true) {
                System.out.println("Do you want to build a new building: y/n");
                String decision = sc.nextLine().toLowerCase();
                if(decision.equals("y")) {
                    return true;
                } else if(decision.equals("n")) {
                    return false;
                }
                System.out.println("Wrong input, please enter y or n");
            }
        }
    }

    public String getInfo() {
        String result = "";
        result += "Name: " + username + " -> money: " + money;
        if(this.isBankrupt()) {
            result += "\nThe player was bankrupted!";
        }
        return result;
    }


}
