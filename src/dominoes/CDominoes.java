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
    
    private int[] domino = new int[3];
    private ArrayList<int[]> dominoList = new ArrayList<>();
    
    public void initializeDominoes(){
        for(int i = 0; i < 7; i++){
            for(int j = i; j < 7; j++){
                domino[0] = i; //left
                domino[1] = j; //right
                domino[2] = 1; //available
                dominoList.add(domino.clone());
            }
        }
    }
     
    public String toString(){
        
        String stateOfDominoes = "";
        int[] dominoTemp = new int[3];
        
        for(int i = 0; i < dominoList.size()-1; i++){
            dominoTemp = dominoList.get(i);
            stateOfDominoes += "Left: " + dominoTemp[0] + " Right: " + dominoTemp[1] + " Available: " + dominoTemp[2] + System.lineSeparator();
        }
        
        return stateOfDominoes;
    }
