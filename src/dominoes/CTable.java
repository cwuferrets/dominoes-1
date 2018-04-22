/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;

import java.util.ArrayList;

/**
 * Stores the state of the sorted pieces.
 */
public class CTable {
    private String boardState;
    private int leftEnd;
    private int rightEnd;
    
    public void firstPiece(int[] domino) {
        boardState = dominoToString(domino);
        this.leftEnd = domino[0];
        this.rightEnd = domino[1];
    }
    
    public boolean playPiece(int[] domino) {
        if (domino[0] == rightEnd) {
            boardState = boardState + dominoToString(domino);
            this.rightEnd = domino[1];
        } else if (domino[1] == leftEnd) {
            boardState = dominoToString(domino) + boardState;
            this.leftEnd = domino[0];
        } else if (domino[0] == leftEnd) {
            flip(domino);
            boardState = dominoToString(domino) + boardState;
            this.leftEnd = domino[0];
        } else if (domino[1] == rightEnd) {
            flip(domino);
            boardState = boardState + dominoToString(domino);
            this.rightEnd = domino[1];
        } else {
            System.out.println("You can't play " + dominoToString(domino) + ". Pick another.");
            return false;
        }
        return true;
    }
    
    public void displayBoard(){
        System.out.println("| "+boardState+" |");
    }
    
    public void displayHand(ArrayList<int[]> playerHand){
        String playerHandDisplay = "";
        for(int i = 0; i < playerHand.size(); i++){
            playerHandDisplay += i + ": " + "|" + playerHand.get(i)[0] + "-" + playerHand.get(i)[1] + "|, ";
        }
        System.out.println(playerHandDisplay);
    }
    
    public boolean canPlay(ArrayList<int[]> playerHand){
        for(int i = 0; i < playerHand.size(); i++){
                if(playerHand.get(i)[0] == leftEnd || playerHand.get(i)[1] == leftEnd || playerHand.get(i)[0] == rightEnd || playerHand.get(i)[1] == rightEnd){
                    return true;
                }
        }
        return false;
    }
    
    private String dominoToString(int[] domino) {
        return "[" + domino[0] + ":" + domino[1] + "]";
    }
    
    private void flip(int[] domino) {
        int temp = domino[0];
        domino[0] = domino[1];
        domino[1] = temp;
    }
}
