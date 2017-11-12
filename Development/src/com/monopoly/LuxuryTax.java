package com.monopoly;

public class LuxuryTax extends RevenueTax{

    private static final double LUX_TAX_AMOUNT = 75;

    @Override
    public Money payTax(Player player) {

        Money taxAmount = new Money(Money.Currency.TurkishLira, LUX_TAX_AMOUNT);
        if(!player.pay(taxAmount)) {
            taxAmount.setAmount(-1);
        }
        return taxAmount;
    }
}
