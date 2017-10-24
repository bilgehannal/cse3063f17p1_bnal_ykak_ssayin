package com.monopoly;

public class Board {

    // MARK: Properties

    private String boardName;
    private Block[] blocks;

    // MARK: Encapsulation


    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBlocks(Block[] blocks) {
        this.blocks = blocks;
    }

    public Block[] getBlocks() {
        return blocks;
    }
}
