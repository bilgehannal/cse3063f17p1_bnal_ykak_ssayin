package com.monopoly;

import java.util.ArrayList;

public class Board {

    // MARK: Properties

    private String boardName;
    private ArrayList<Block> blocks;

    // MARK: Constructors

    public Board() {

        blocks = new ArrayList<Block>();

        blocks.add(new Area("Besiktas", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Kadıkoy", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Uskudar", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Atasehir", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Besiktas2", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Kadıkoy2", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Uskudar2", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Atasehir2", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Besiktas3", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Kadıkoy3", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Uskudar3", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Atasehir3", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Besiktas4", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Kadıkoy5", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Uskudar5", new Money("Monopoly Money", 100)));
        blocks.add(new Area("Atasehir5", new Money("Monopoly Money", 100)));
    }

    // MARK: Encapsulation


    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBlocks(ArrayList<Block> blocks) {
        this.blocks = blocks;
    }

    public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
