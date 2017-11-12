package com.monopoly;

public class IncomeTax extends RevenueTax {

    private static final double PERCENTAGE_OF_TAX = 10;

    @Override
    public Money payTax(Player player) {

        double currentMoneyOfPlayer = player.getMoney().getAmount();
        double taxValue = (currentMoneyOfPlayer / 100.0) * (100.0 - PERCENTAGE_OF_TAX);
        Money taxAmount = new Money(Money.Currency.TurkishLira, taxValue);
        if(!player.pay(taxAmount)) {
            taxAmount.setAmount(-1);
        }
        return taxAmount;
    }
}
