package com.monopoly;

public class Area extends Block {

    // MARK: Properties

    private String name;
    private Municipality municipality;
    private Deed deed;

    // CONSTRUCTOR

    public Area(String name, Deed deed) {
        this.name = name;
        this.deed = deed;
    }

    //MARK: Encapsulation


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setDeed(Deed deed) {
        this.deed = deed;
    }

    public Deed getDeed() {
        return deed;
    }

    // MARK: Utilities

    @Override
    public void interact(Player player) {

        if(deed.getOwner() == null) {
            if(player.wantToBuyArea(this)) {
                if(player.pay(deed.getPrice())) {
                    deed.setOwner(player);
                    System.out.println(name + " is bought by " + player.getUsername());
                } else {
                    player.setBankrupt(true);
                }
            }
        } else {
            if (player.getHasRentExemption()) {
                System.out.println(player.getUsername() + " has rent exemption. So s/he pays nothing this time.");
                player.setHasRentExemption(false);
            }else {
                if(player.pay(deed.getOwner(), getTotalRent())) {
                    System.out.println(player.getUsername() + " paid "
                            + getTotalRent() + " to " + deed.getOwner().getUsername() + " for rent.");
                } else {
                    if(deed.getOwner() != player) {
                        player.setBankrupt(true);
                    }
                }


            }
        }
    }

    // getTotalRent calculates the total rent value as a money and returns.
    public Money getTotalRent() {
        return deed.getRentPrice();
    }


}
