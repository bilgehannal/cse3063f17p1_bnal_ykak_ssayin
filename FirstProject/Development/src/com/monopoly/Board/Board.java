package com.monopoly.Board;
import com.monopoly.Bank.Deed;
import com.monopoly.Bank.Money;
import com.monopoly.Board.Blocks.*;
import com.monopoly.Manager.Manager;
import com.monopoly.Player.Position;

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
        blocks.add(new EmptyBlock());

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
            double rentAmount0 = Double.parseDouble(words[3]);
            double rentAmount1 = Double.parseDouble(words[4]);
            double rentAmount2 = Double.parseDouble(words[5]);
            double rentAmount3 = Double.parseDouble(words[6]);
            double rentAmount4 = Double.parseDouble(words[7]);
            Money moneyPrice = new Money(Money.Currency.TurkishLira,priceAmount);
            Money moneyRent0 = new Money(Money.Currency.TurkishLira,rentAmount0);
            Money moneyRent1 = new Money(Money.Currency.TurkishLira,rentAmount1);
            Money moneyRent2 = new Money(Money.Currency.TurkishLira,rentAmount2);
            Money moneyRent3 = new Money(Money.Currency.TurkishLira,rentAmount3);
            Money moneyRent4 = new Money(Money.Currency.TurkishLira,rentAmount4);
            Deed deed = new Deed(moneyPrice, moneyRent0, moneyRent1, moneyRent2, moneyRent3, moneyRent4);
            block = new Area(areaName, deed);

        } else if(words[0].toLowerCase().contains("incometax")) {
            block = new IncomeTax();
        } else if(words[0].toLowerCase().contains("luxurytax")) {
            block = new LuxuryTax();
        } else if(words[0].toLowerCase().contains("goprison")) {
            block = new GoPrison();
        } else if(words[0].toLowerCase().contains("visitprison")) {
            int positionOfPrison = blocks.size();
            Manager.getInstance().setPrisonPosition(new Position(positionOfPrison));
            block = new VisitPrison(new Money(Money.Currency.TurkishLira,500000));
        } else if(words[0].toLowerCase().contains("EmptyBlock")) {
            block = new EmptyBlock();
        } else if(words[0].toLowerCase().contains("freeparking")) {
            block = new FreeParking();
        } else if(words[0].toLowerCase().contains("electricityUtility")) {
            block = new UtilityArea("ElectricityUtility",new Deed(new Money(Money.Currency.TurkishLira,150000),new Money(Money.Currency.TurkishLira,10000)));
        } else if(words[0].toLowerCase().contains("waterUtility")) {
            block = new UtilityArea("WaterUtility",new Deed(new Money(Money.Currency.TurkishLira,150000),new Money(Money.Currency.TurkishLira,10000)));
        } else if(words[0].toLowerCase().contains("railroad")) {
            block = new UtilityArea("Railroad",new Deed(new Money(Money.Currency.TurkishLira,200000),new Money(Money.Currency.TurkishLira,5000)));
        }

        return block;
    }
}
