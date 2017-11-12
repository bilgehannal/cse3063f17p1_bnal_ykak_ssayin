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
        if(!taxAmount.getAmount() == -1) {
            System.out.println(taxAmount.toString() + " is paid to the Bank at Revenue Block.");
        } else {
            player.setBankrupt(true);
        }

    }

    public abstract Money payTax(Player player);
}
