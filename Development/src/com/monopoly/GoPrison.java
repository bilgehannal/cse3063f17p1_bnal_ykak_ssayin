package com.monopoly;

public class GoPrison extends Block {

    //MARK: Properties

    private Money penance;

    // MARK: Constructor

    public GoPrison(Money penance) {
        this.penance = penance;
        penance.setAmount(50000);
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
        System.out.println(player.getUsername() + " came into Prison Block");
        if(player.pay(penance)) {
            System.out.println(player.getUsername() + " paid tax:" + penance );
        } else {
            player.setInJail(true);
            player.setInJailTime(player.getInJailTime()+1);
            System.out.println(player.getUsername() + " is in Prison for 3 turns");
        }
    }
}
