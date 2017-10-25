package com.monopoly.utilities;

import com.monopoly.Player;

import java.util.Comparator;

public class PlayerComparator implements Comparator<Player> {

    @Override
    public int compare(Player o1, Player o2) {
        if (o1.getTotalDiceValue() > o2.getTotalDiceValue()) {
            return 1;
        } else if(o1.getTotalDiceValue() == o2.getTotalDiceValue()) {
            return 0;
        } else {
            return -1;
        }
    }
}
