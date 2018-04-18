/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;

import java.util.Random;
import java.util.List;
import java.util.Collections;

/**
 * Determines random elements of the game, such as the order domino pieces will
 * be picked, who moves first,
 */
public class CRandom {
    private final Random rand;
    
    /**
     * Constructor
     */
    public CRandom() {
        this.rand = new Random();
    }
    
    /**
     * Determines if player one is first by uniform distribution
     * @return true if player one should go first
     */
    public boolean isPlayerOneFirst() {
        return rand.nextBoolean();
    }
    /**
     * Shuffles dominoes with uniform distribution
     * @param list is a list of dominoes to be shuffled
     */
    public void shuffleDominoes(List list) {
        Collections.shuffle(list);
    }
}
