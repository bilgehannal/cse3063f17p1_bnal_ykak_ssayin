package com.monopoly;

public class Beginning extends Block {

    @Override
    public void interact(Player player) {
        System.out.println(player.getUsername() + " is in the beginning block of the board. Enjoy your "
                + Manager.getInstance().getMoneyAmountPerTurnOfBoard());
    }
}
