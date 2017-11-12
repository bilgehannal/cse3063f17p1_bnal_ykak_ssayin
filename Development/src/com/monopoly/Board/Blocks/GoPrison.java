package com.monopoly.Board.Blocks;

import com.monopoly.Manager.Manager;
import com.monopoly.Player.Player;

public class GoPrison extends Block {

    @Override
    public void interact(Player player) {
        System.out.println(player.getUsername() + " is heading to the prison block!");
        Manager.getInstance().sendPrison(player);
    }
}
