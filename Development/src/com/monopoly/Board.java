package com.monopoly;

import java.util.ArrayList;

public class Board {

    // MARK: Properties

    private String boardName;
    private ArrayList<Block> blocks;

    // MARK: Constructors

    public Board() {

        blocks = new ArrayList<Block>();

        blocks.add(new Area("Kadikoy",  new Deed(new Money(Money.Currency.TurkishLira,220),
                new Money(Money.Currency.TurkishLira,64))));
        blocks.add(new Area("Beykoz",  new Deed(new Money(Money.Currency.TurkishLira,400),
                new Money(Money.Currency.TurkishLira,78))));

        blocks.add(new Area("Uskudar",  new Deed(new Money(Money.Currency.TurkishLira,604),
                new Money(Money.Currency.TurkishLira,98))));

        blocks.add(new Area("Besiltas",  new Deed(new Money(Money.Currency.TurkishLira,458),
                new Money(Money.Currency.TurkishLira,14))));

        blocks.add(new Area("Beylikduzu",  new Deed(new Money(Money.Currency.TurkishLira,654),
                new Money(Money.Currency.TurkishLira,65))));

        blocks.add(new Area("bagcilar",  new Deed(new Money(Money.Currency.TurkishLira,786),
                new Money(Money.Currency.TurkishLira,79))));

        blocks.add(new Area("maltepe",  new Deed(new Money(Money.Currency.TurkishLira,456),
                new Money(Money.Currency.TurkishLira,45))));


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
