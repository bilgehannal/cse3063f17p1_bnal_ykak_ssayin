package com.monopoly;

public class VisitPrison extends Block {

    // MARK: Constructor
    public VisitPrison() {
    }

    // MARK: Utility Methods
    // Since nothing happens when we move onto visiting jail block, our interact method is empty.
    @Override
    public void interact(Player player) {
        System.out.println(player.getUsername() + " is safe... For now!");
    }
}
