package com.monopoly.UnitTest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import com.monopoly.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();
    Player player4 = new Player();
    Position pos = new Position(1);
    private ArrayList<Player> players;
    String nameSet[] = {"Doc","Grumpy","Happy","Sleepy","Dopey","Bashful","Sneezy"};
    @Test
    void getInstance() {
        assertEquals(Manager.getInstance(),Manager.getInstance());
    }

    @Test
    void setWinner() {
    }

    @Test
    void addPlayer() {
    }
    @Test
    void getNameFromNameSet() {
        String name = Manager.getInstance().getNameFromNameSet();
        boolean nameFound = false;
        for (int i = 0;i<nameSet.length; i++){
            if (nameSet[i] == name){
                nameFound = true;
                break;
            }
            else
                nameFound = false;
        }
        assertTrue(nameFound);
    }

    @Test
    void canMoveNextIteration() {
        Manager.getInstance().setMaxNumberOfIterations(20);
        Manager.getInstance().setCurrentIteration(5);
        assertTrue(Manager.getInstance().canMoveNextIteration() == true);
        Manager.getInstance().setMaxNumberOfIterations(10);
        Manager.getInstance().setCurrentIteration(11);
        assertTrue(Manager.getInstance().canMoveNextIteration() == false);
    }
    @Test
    void reorderPlayers() {


    }

    @Test
    void printGameInfo() {
    }

    @Test
    void play() {
    }

}