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
    private ArrayList<int[]> playedDominoList = new ArrayList<>();
    
    public void firstPiece(int[] domino) {
        boardState = dominoToString(domino);
        this.leftEnd = domino[0];
        this.rightEnd = domino[1];
    }
    
    public boolean playPiece(int[] domino) {
        if (domino[0] == rightEnd) {
            boardState = boardState + dominoToString(domino);
        } else if (domino[1] == leftEnd) {
            boardState = dominoToString(domino) + boardState;
        } else if (domino[0] == leftEnd) {
            flip(domino);
            boardState = dominoToString(domino) + boardState;
        } else if (domino[1] == rightEnd) {
            flip(domino);
            boardState = boardState + dominoToString(domino);
        } else {
            System.out.print("You can't play that piece. Pick another.");
            return false;
        }
        playedDominoList.add(domino);
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
            for(int j = 0; j < playedDominoList.size(); j++){
                if(playerHand.get(i)[0] == playedDominoList.get(j)[0] && playerHand.get(i)[1] == playedDominoList.get(j)[1]){
                    return false;
                }
            }
        }
        return true;
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
