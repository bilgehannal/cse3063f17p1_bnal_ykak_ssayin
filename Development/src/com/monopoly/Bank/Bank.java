package com.monopoly.Bank;

import com.monopoly.Player.Player;

// Singleton design pattern. Since we would like to assure bank instance will be created only once.
public class Bank {

    // MARK: Properties
    private static Bank sharedBank;
    private Money money;

    // MARK: Constants
    private final double initialBankMoney = 100000000;

    // MARK: Constructors
    protected Bank() {
        // Assuming all money over the game is limited with 100M ₺.
        money = new Money(Money.Currency.TurkishLira,initialBankMoney);
    }

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
    public boolean pay(Player player, Money money) {
        if (this.money.getAmount() > money.getAmount()) {
            player.addMoney(money);
            this.money.setAmount(this.money.getAmount() - money.getAmount());
            return true;
        }
        return false;
    }

    public boolean receivePayment(Player player,Money money) {
        if (player.pay(money)){
            this.money.setAmount(this.money.getAmount() + money.getAmount());
            return true;
        }
        return false;
    }

}


