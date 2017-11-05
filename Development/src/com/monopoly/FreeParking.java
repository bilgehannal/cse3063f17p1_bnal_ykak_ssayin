package com.monopoly;

public class FreeParking extends Block {

    @Override
    public void interact(Player player) {
        player.setHasRentExemption(true);
        System.out.println(player.getUsername()
                + " is on Free Parking! Now, s/he will be exempted from paying rent next time.");
    }
}
