package com.monopoly;
import java.awt.geom.Area;
import java.util.Random;

public class Player {

    // MARK: Properties
    private String ID;
    private String username;
    private Position position;
    private Money money;
    private Area[] ownedAreas;
    private Die[] dice;

    // MARK: Constructor
    public Player(String username) {
        this.username = username;
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

    public Area[] getOwnedAreas() { return this.ownedAreas; }

    public void setOwnedAreas(Area[] ownedAreas) { this.ownedAreas = ownedAreas; }

    public Die[] getDice() { return this.dice; }

    public void setDice(Die[] dice) { this.dice = dice; }


    // MARK: Utility Methods
    public void addMoney(Money money) {

        this.money.amount = this.money.amount + money.amount;
    }

    private boolean canPay(Money money){
        if (this.money.amount > money.amount) {
            return true;
        }
        return false;
    }

    public boolean pay(Money money){
        if (canPay(money.amount)){
            this.money.amount -= money.amount;
            return true;
        }
        return false;
    }
    public int[] rollDice() {
        int[] diceArray = new int[2];
        Random generator = new Random();

        for (int i = 0; i <diceArray.length ; i++) {
            diceArray[i] = generator.nextInt(6)+1;
        }

        return diceArray;
    }
}
