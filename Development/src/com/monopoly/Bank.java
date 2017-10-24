package com.monopoly;

// Singleton design pattern. Since we would like to assure bank instance will be created only once.
public class Bank {

    // MARK: Properties
    private static Bank sharedBank;
    private Money money;

    // MARK: Constructors
    protected Bank() { }

    public static Bank getInstance() {

        if (sharedBank == null) {
            sharedBank = new Bank();
        }
        return sharedBank;
    }

    // MARK: Encapsulation
    public double getMoney() {
        return this.money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    // MARK: Utility Methods
    public boolean pay(Player player,double amount) {
        if (this.currency > amount) {
            player.addCurrency(amount);
            this.currency -= amount;
            return true;
        }
        return false;
    }

    public boolean receivePayment(Player player,double amount) {
        if (player.pay(amount)){
            this.currency += amount;
            return true;
        }
        return false;
    }

}


