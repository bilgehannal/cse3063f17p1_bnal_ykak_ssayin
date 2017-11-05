package com.monopoly;

public abstract class RevenueTax extends Block {

    // MARK: Properties

    private Money taxAmount;

    // CONSTRUCTOR:

    //MARK: Encapsulation


    public void setTaxAmount(Money taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Money getTaxAmount() {
        return taxAmount;
    }

    @Override
    public void interact(Player player) {
        Money taxAmount = payTax(player);
        System.out.println(taxAmount.toString() + " is paid to the Bank at Revenue Block.");
    }

    public abstract Money payTax(Player player);
}
