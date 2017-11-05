package com.monopoly;

public class LuxuryTax extends RevenueTax{

    @Override
    public Money payTax(Player player) {

        Money taxAmount = new Money(Money.Currency.TurkishLira, 75);
        player.pay(taxAmount);
        return taxAmount;
    }
}
