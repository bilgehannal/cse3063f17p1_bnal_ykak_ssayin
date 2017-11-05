package com.monopoly;

public class IncomeTax extends RevenueTax {

    @Override
    public Money payTax(Player player) {

        double currentMoneyOfPlayer = player.getMoney().getAmount();
        double taxValue = currentMoneyOfPlayer / 10.0;
        Money taxAmount = new Money(Money.Currency.TurkishLira, taxValue);
        player.pay(taxAmount);
        return taxAmount;
    }
}
