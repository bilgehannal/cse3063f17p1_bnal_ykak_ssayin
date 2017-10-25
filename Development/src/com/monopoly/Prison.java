package com.monopoly;

public class Prison extends Block {

    //MARK: Properties

    private Money penance;

    // MARK: Constructor

    public Prison(Money penance) {
        this.penance = penance;
    }

    //MARK: Encapsulation


    public void setPenance(Money penance) {
        this.penance = penance;
    }

    public Money getPenance() {
        return penance;
    }

    @Override
    public void interact(Player player) {
        if(player.pay(penance)) {
            ""
        } else {

        }
    }
}
