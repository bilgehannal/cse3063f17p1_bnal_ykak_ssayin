package com.monopoly.UnitTest;

import com.monopoly.Manager.Manager;
import com.monopoly.Player.Player;
import com.monopoly.Player.Position;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Player player = new Player();
    Position pos = new Position(1);
    String nameSet[] = {"Doc","Grumpy","Happy","Sleepy","Dopey","Bashful","Sneezy"};
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInstance() {
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
    void move() {
        //int initialIndex = player.getPosition().getIndex();
        //int finalIndex = Manager.getInstance().move(player,5).getIndex();
        //assertEquals(initialIndex+5,finalIndex);
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