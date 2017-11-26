package com.monopoly.Board.Blocks;

import com.monopoly.Manager.Manager;
import com.monopoly.Player.Player;

public class EmptyBlock extends Block {

    @Override
    public void interact(Player player) {
        System.out.println(player.getUsername() + " is in the beginning block of the board. Enjoy your "
                + Manager.getInstance().getMoneyAmountPerTurnOfBoard());
    }
}