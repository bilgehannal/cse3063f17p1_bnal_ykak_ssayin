package com.monopoly;

import jdk.nashorn.internal.ir.BlockLexicalContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Board {

    // MARK: Properties

    private String boardName;
    private ArrayList<Block> blocks;

    // MARK: Constructors

    public Board() {

        blocks = new ArrayList<Block>();
        blocks.add(new Beginning());

        String[] blockStrings = getBlockStrings();
        for (String str : blockStrings ) {
            Block block = createBlock(str);
            if(block instanceof Block) {
                blocks.add(block);
            }
        }
        System.out.println("There are/is " + blocks.size() + " block determined.");
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

    // MARK: Utilities
    private String[] getBlockStrings() {
        String content = null;
        try {
            content = new Scanner(new File("board.txt")).useDelimiter("\\Z").next();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(content != null) {
            return content.split("\n");
        } else {
            return null;
        }

    }

    private Block createBlock(String blockString) {

        Block block = null;
        String[] words = blockString.split(" ");

        if(words[0].toLowerCase().contains("area")) {
            String areaName = words[1];
            double priceAmount = Double.parseDouble(words[2]);
            double rentAmount = Double.parseDouble(words[3]);
            Money moneyPrice = new Money(Money.Currency.TurkishLira,priceAmount);
            Money moneyRent = new Money(Money.Currency.TurkishLira,rentAmount);
            Deed deed = new Deed(moneyPrice, moneyRent);
            block = new Area(areaName, deed);

        } else if(words[0].toLowerCase().contains("incometax")) {
            block = new IncomeTax();
        } else if(words[0].toLowerCase().contains("luxurytax")) {
            block = new LuxuryTax();
        } else if(words[0].toLowerCase().contains("goprison")) {
            block = new GoPrison(new Money(Money.Currency.TurkishLira,50000));
        } else if(words[0].toLowerCase().contains("visitprison")) {
            block = new VisitPrison();
        }

        return block;
    }
}
