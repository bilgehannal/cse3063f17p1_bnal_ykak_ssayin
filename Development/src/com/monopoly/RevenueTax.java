package com.monopoly;

public class RevenueTax extends Block {

    // MARK: Properties

    private Money taxAmount;

    // CONSTRUCTOR:
    public RevenueTax(Money taxAmount) {
        this.taxAmount = taxAmount;
    }

    //MARK: Encapsulation


    public void setTaxAmount(Money taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Money getTaxAmount() {
        return taxAmount;
    }

    @Override
    public void interact(Player player) {
        double currentMoneyOfPlayer = player.getMoney().getAmount();
        double taxValue = currentMoneyOfPlayer / 10.0;
        taxAmount.setAmount(taxValue);
        player.pay(taxAmount);
        System.out.println(taxValue + " monopoly money is paid to the Bank at RevenueTax Block ");

    }


}
