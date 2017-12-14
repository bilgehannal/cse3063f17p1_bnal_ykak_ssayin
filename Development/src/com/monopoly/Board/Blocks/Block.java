package com.monopoly.Board.Blocks;

import com.monopoly.Player.Player;
import com.monopoly.Player.Position;

public abstract class Block {

    // MARK: Properties

    private String blockName;
    private Position position;
    // MARK: Encapsulation


    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    public String getBlockName() {
        return blockName;
    }

    public abstract void interact(Player player);
}
