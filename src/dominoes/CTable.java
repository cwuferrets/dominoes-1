/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;

/**
 * Stores the state of the sorted pieces.
 */
public class CTable {
    String boardState;
    int leftEnd;
    int rightEnd;
    
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
