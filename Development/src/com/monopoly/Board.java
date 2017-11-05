package com.monopoly;

import java.util.ArrayList;

public class Board {

    // MARK: Properties

    private String boardName;
    private ArrayList<Block> blocks;

    // MARK: Constructors

    public Board() {

        blocks = new ArrayList<Block>();

        blocks.add(new Area("Besiktas", new Money(Money.Currency.TurkishLira,100)));

        blocks.add(new IncomeTax());
        blocks.add(new GoPrison(new Money(Money.Currency.TurkishLira,50000)));
        blocks.add(new VisitPrison());
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
