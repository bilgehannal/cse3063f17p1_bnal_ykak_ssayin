package com.monopoly.Board.Blocks;

import com.monopoly.Bank.Deed;
import com.monopoly.Bank.Money;
import com.monopoly.Board.Building.Building;
import com.monopoly.Board.Building.BuildingType;
import com.monopoly.Player.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Area extends Block {

    // MARK: Properties

    private String name;
    private Deed deed;
    private ArrayList<Building> buildings;
    private boolean isBuildable;

    // CONSTRUCTOR

    public Area(String name, Deed deed) {
        this.name = name;
        this.deed = deed;
        buildings = new ArrayList<Building>();
        isBuildable = true;
    }

    //MARK: Encapsulation


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDeed(Deed deed) {
        this.deed = deed;
    }

    public Deed getDeed() {
        return deed;
    }

    public void setBuildable(boolean buildable) {
        isBuildable = buildable;
    }

    public boolean isBuildable() {
        return isBuildable;
    }

    public void setBuildings(ArrayList<Building> buildings) {
        this.buildings = buildings;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }

    // MARK: Utilities

    @Override
    public void interact(Player player) {
        if(deed.getOwner() == null) {
            interactNotOwnedArea(player);
        } else {
            interactOwnedArea(player);
        }
    }

    private void interactNotOwnedArea(Player player) {
        boolean permissionForNewArea = player.canPay(this.getDeed().getPrice());
        if(permissionForNewArea) {
            if (player.wantToBuyArea(this)) {
                if (player.pay(deed.getPrice())) {
                    deed.setOwner(player);
                    player.getOwnedAreas().add(this);
                    System.out.println(name + " is bought by " + player.getUsername());
                }
            }
        }

    }

    private void interactOwnedArea(Player player) {
        if(deed.getOwner() == player) {
            // This area belongs to the player
            if(isBuildable()) {
                newBuildingRequest(player);
            }
        } else {
            // This area does not belong to player
            if (player.getHasRentExemption()) {
                System.out.println(player.getUsername() + " has rent exemption. So s/he pays nothing this time.");
                player.setHasRentExemption(false);
            }else {
                if (deed.getOwner().getisInJail()) {
                    System.out.println("Since the owner of this area is in prison, " + player.getUsername()
                            + "won't pay a rent for this area, this time.");
                }else {
                    if(player.pay(deed.getOwner(), getTotalRent())) {
                        System.out.println(player.getUsername() + " paid "
                                + getTotalRent() + " to " + deed.getOwner().getUsername() + " for rent.");
                    } else {
                        player.setBankrupt(true);
                    }
                }
            }
        }
    }

    private void newBuildingRequest(Player player) {
        int numberOfBuilding = getBuildings().size();
        boolean permissionForNewBuilding = true;
        for (Area area : player.getOwnedAreas()) {
            if(area.getBuildings().size() < numberOfBuilding) {
                permissionForNewBuilding = false;
                break;
            }
        }
        if(numberOfBuilding == 4) {
            permissionForNewBuilding = false;
        }
        if(permissionForNewBuilding) {
            Building newBuilding;
            if(numberOfBuilding == 3) {
                newBuilding = new Building(BuildingType.Hotel);
            } else {
                newBuilding = new Building(BuildingType.House);
            }

            if(player.canPay(newBuilding.getPrice())) {
                if(player.wantToBuildNewBuilding(newBuilding)) {
                    if(player.pay(newBuilding.getPrice())) {
                        getBuildings().add(newBuilding);
                        System.out.println("There is a building was built by " + player.getUsername());
                    }
                }
            }

        }
    }

    // getTotalRent calculates the total rent value as a money and returns.
    public Money getTotalRent() {
        return deed.getRentPrices()[this.buildings.size()]; // Returns according to the number of buildings owned
    }


}
