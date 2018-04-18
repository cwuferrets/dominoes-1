/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;
import java.util.*;
/**
 * Represents the player. Selects a random domino from the pile.
 * Can print the selected pieces.
 */
public class CPlayer {
    
    private ArrayList<int[]> playerHand = new ArrayList<>();
    
    public void initilizeHand(ArrayList<int[]> dominoeBag){
        int index = 0;
        while(playerHand.size() < 10){
            if(dominoeBag.get(index)[2] == 1){
                playerHand.add(dominoeBag.get(index));
                dominoeBag.get(index)[2] = 0;
                index++;
            }else{
                index++;
            }
        }
    }
    
    public ArrayList<int[]> getPlayerHand(){
        return playerHand;
    }
    
    public void updatePlayerHand(ArrayList<int[]> newHand){
        playerHand = newHand;
    }
    
    public void drawDominoe(ArrayList<int[]> dominoBag){
        int index = 0;
        boolean foundDomino = false;
        while(!foundDomino && index < 28){
            if(dominoBag.get(index)[2] == 1){
                playerHand.add(dominoBag.get(index));
                dominoBag.get(index)[2] = 0;
                foundDomino = true;
            }else{
                index++;
            }
        }
    }
    
}
