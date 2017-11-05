package com.monopoly;
import java.util.ArrayList;
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
    private boolean autoPlay;
    private boolean inJail;
    private int inJailTime;

    // MARK: Constants
    private final int initialMoney = 2000000;

    // MARK: Constructor
    public Player(String username) {
        this();
        this.username = username;
        this.autoPlay = false;
        this.inJail = false;
        this.inJailTime = 0;

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

    public boolean isInJail() {
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

    // MARK: Utility Methods
    public void addMoney(Money money) {
        double newAmount = this.money.getAmount() + money.getAmount();
        this.money.setAmount(newAmount);
    }

    // Pay methods to player and bank

    private boolean canPay(Money money){
        if (this.money.getAmount() > money.getAmount()) {
            return true;
        }
        return false;
    }


    public boolean pay(Money money){
        if (canPay(money)){
            double newAmount = this.money.getAmount() - money.getAmount();
            this.money.setAmount(newAmount);
            double currentBankAmount = Bank.getInstance().getMoney().getAmount();
            Bank.getInstance().getMoney().setAmount(currentBankAmount + money.getAmount());
            return true;
        }
        return false;
    }

    public boolean pay(Player player, Money money) {
        if(canPay(money)) {
            player.getMoney().setAmount(player.getMoney().getAmount() + money.getAmount());
            this.money.setAmount(this.money.getAmount() - money.getAmount());
            return true;
        }
        return false;
    }


    // Dice methods

    public void rollDice() {
        Random generator = new Random();

        for (int i = 0; i <dice.size() ; i++) {
            int newFaceValue = generator.nextInt(6)+1;
            dice.get(i).setFaceValue(newFaceValue);
        }
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
        if(this.isAutoPlay()) {
            int randomNumber = (int)((Math.random()*2) + 1);
            return (randomNumber == 1) ? true : false; // If randomNumber is 1 then, buy the area
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


}
