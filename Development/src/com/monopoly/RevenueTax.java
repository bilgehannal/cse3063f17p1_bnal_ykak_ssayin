package com.monopoly;

public class RevenueTax extends Block {

    // MARK: Properties

    private Money taxAmount;

    //MARK: Encapsulation


    public void setTaxAmount(Money taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Money getTaxAmount() {
        return taxAmount;
    }

    @Override
    public void interact(Player player) {

    }


}
