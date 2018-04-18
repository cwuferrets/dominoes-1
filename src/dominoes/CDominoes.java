/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;
import java.util.*;

/**
 * Data structure to represent domino pieces.
 */
public class CDominoes {
    
    int[] dominoe = new int[3];
    ArrayList<int[]> dominoeList = new ArrayList<>();
    
    public void initializeDominoes(){
        for(int i = 0; i < 7; i++){
            for(int j = i; j < 7; j++){
                dominoe[0] = i; //left
                dominoe[1] = j; //right
                dominoe[2] = 1; //available
                dominoeList.add(dominoe.clone());
            }
        }
    }
     
    public String toString(){
        
        String stateOfDominoes = "";
        int[] dominoeTemp = new int[3];
        
        for(int i = 0; i < dominoeList.size()-1; i++){
            dominoeTemp = dominoeList.get(i);
            stateOfDominoes += "Left: " + dominoeTemp[0] + " Right: " + dominoeTemp[1] + " Available: " + dominoeTemp[2] + System.lineSeparator();
        }
        
        return stateOfDominoes;
    }
}
