package com.monopoly.Board.Blocks;

import com.monopoly.Manager.Manager;
import com.monopoly.Bank.Money;
import com.monopoly.Player.Player;

public class VisitPrison extends Block {

    //MARK: Properties
    private static Money penance;

    // MARK: Constructor
    public VisitPrison(Money penance) {
        this.setBlockName("VisitPrison");
        this.penance = penance;
    }

    //MARK: Encapsulation
    public static void setPenance(Money newPenance) {
        penance = newPenance;
    }

    public static Money getPenance() {
        return penance;
    }

    // MARK: Utility Methods
    @Override
    public void interact(Player player) {
        if (player.getisInJail()) {
            System.out.println(player.getUsername() + " came into Prison Block");
            if(player.pay(penance)) {
                System.out.println(player.getUsername() + " paid tax:" + penance );
                player.setInJail(false);
            } else {
                player.setInJail(true);
                player.setInJailTime(player.getInJailTime()+1);
                System.out.println(player.getUsername() + " is in Prison for 3 turns");
            }
        }else {
            System.out.println(player.getUsername() + " is safe... For now!");
        }
    }

    public static void handleIfPlayerInPrison(Player player) {
        if (player.getInJailTime() == 3){
            System.out.println(player.getUsername() + "is out of jail");
            player.setInJail(false);
        }
        else {
            if (player.pay(VisitPrison.getPenance())) {
                player.setInJail(false);
            } else {
                player.rollDice();
                if (Manager.getInstance().checkForDouble(player)) {
                    player.setInJail(false);
                    System.out.println(player.getUsername() + "is out of jail");
                } else {
                    System.out.println(player.getUsername() + " is in jail");
                    player.setInJailTime(player.getInJailTime() + 1);
                }
            }
        }
    }
}
