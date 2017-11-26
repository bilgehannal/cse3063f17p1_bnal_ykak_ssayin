package com.monopoly.Board.Blocks;

import com.monopoly.Bank.Bank;
import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;

public class LuxuryTax extends RevenueTax {

    private static final double LUX_TAX_AMOUNT = 75;

    @Override
    public Money payTax(Player player) {

        Money taxAmount = new Money(Money.Currency.TurkishLira, LUX_TAX_AMOUNT);
        if(Bank.getInstance().receivePayment(player, taxAmount)) {
            taxAmount.setAmount(-1);
        }
        return taxAmount;
    }
}
