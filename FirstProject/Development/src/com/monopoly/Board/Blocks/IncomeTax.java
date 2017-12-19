package com.monopoly.Board.Blocks;

import com.monopoly.Bank.Bank;
import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;

public class IncomeTax extends RevenueTax {

    private static final double PERCENTAGE_OF_TAX = 10;

    @Override
    public Money payTax(Player player) {

        double currentMoneyOfPlayer = player.getMoney().getAmount();
        double taxValue = (currentMoneyOfPlayer / 100.0) * (PERCENTAGE_OF_TAX);
        Money taxAmount = new Money(Money.Currency.TurkishLira, taxValue);
        if(!Bank.getInstance().receivePayment(player, taxAmount)) {
            taxAmount.setAmount(-1);
        }
        return taxAmount;
    }
}
