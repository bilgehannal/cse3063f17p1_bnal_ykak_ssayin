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
    public Money getMoney() {
        return this.money;
    }

    public void setMoney(Money money) {
        this.money = money;
    }

    // MARK: Utility Methods
    public boolean pay(Player player,Money money) {
        if (this.money.getAmount() > money.getAmount()) {
            player.addCurrency(money.getAmount());
            this.money.setAmount(money.getAmount());
            return true;
        }
        return false;
    }

    public boolean receivePayment(Player player,Money money) {
        if (player.pay(money.getAmount())){
            this.money.setAmount(money.getAmount());
            return true;
        }
        return false;
    }

}


