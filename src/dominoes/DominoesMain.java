/*
 * Jesse Calvert, Parker Jones
 * CS380 Project 1
 * 4/17/2018
 */
package dominoes;

import java.util.Scanner;

/**
 * Main API for the program. Controls and manages the game.
 */
public class DominoesMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create Dominoes
        CDominoes dominoBag = new CDominoes();
        dominoBag.initializeDominoes();
        //shuffleDominoes
        CRandom r = new CRandom();
        r.shuffleDominoes(dominoBag.getDominoList());
        //create players
        CPlayer p1 = new CPlayer();
        p1.initializeHand(dominoBag.getDominoList());
        CPlayer p2 = new CPlayer();
        p2.initializeHand(dominoBag.getDominoList());
        //create table
        CTable table = new CTable();
        //who first, first piece
        boolean playerOneTurn = r.isPlayerOneFirst();
        Scanner s = new Scanner(System.in);
        if (playerOneTurn) {
            System.out.println("Player One is first. What domino will you play?");
            /*
            Scanner logic
            */
        } else {
            System.out.println("Player Two is first. What domino will you play?");
            /*
            Scanner logic
            */
        }
        gameLoop(table, p1, p2, dominoBag, playerOneTurn, s);
    }
    
    public static void gameLoop(CTable table, CPlayer p1, CPlayer p2, CDominoes dominoBag, boolean playerOneTurn, Scanner s) {
        int passCounter = 0
        while(p1.getPlayerHand.size() > 0 && p2.getPlayerHand.size() > 0 && passCounter < 2) {
            if (playerOneTurn) {
                //display table (NEEDS GETTER)
                //display hand
                //"pick a piece"
                int pickedPiece;
                if () { //play possible
                    while (!table.playDomino()) {
                        //display table (maybe getter)
                        //display hand
                        pickedPiece = s.nextInt();
                    }
                    //play domino
                    passCounter = 0;
                } else { //play impossible
                    if () { //draw possible
                        
                    } else () { //pass
                        passCounter++;
                    }
                }
            } else { //same as above but for p2
                while (!table.playDomino()) {
                        //display table (maybe getter)
                        //display hand
                        pickedPiece = s.nextInt();
                    }
                    //play domino
                    passCounter = 0;
                } else { //play impossible
                    if () { //draw possible
                        
                    } else () { //pass
                        passCounter++;
                    }
                }
            }
            playerOneTurn = !playerOneTurn;
        }
    //determine winner
    //print win message
    }
}
