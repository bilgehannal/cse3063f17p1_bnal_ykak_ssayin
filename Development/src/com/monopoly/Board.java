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
        blocks.add(new Area("Kadıkoy", new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new Area("Uskudar", new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new Area("Atasehir", new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new RevenueTax(new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new RevenueTax(new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new RevenueTax(new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new RevenueTax(new Money(Money.Currency.TurkishLira,100)));
        blocks.add(new RevenueTax(new Money(Money.Currency.TurkishLira,100)));
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
