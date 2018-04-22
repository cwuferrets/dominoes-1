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
        CPlayer p2 = new CPlayer();
        //create table
        CTable table = new CTable();
        //pick first domino for table
        table.firstPiece(dominoBag.getDominoList().get(0));
        dominoBag.getDominoList().get(0)[2] = 0;
        //who first
        boolean playerOneTurn = r.isPlayerOneFirst();
        Scanner s = new Scanner(System.in);
        //draw hands
        p1.initilizeHand(dominoBag.getDominoList());
        p2.initilizeHand(dominoBag.getDominoList());
        if (playerOneTurn) {
            System.out.println("Player One is first.");
        } else {
            System.out.println("Player Two is first.");
        }
        System.out.println("How many people are playing?");
        System.out.println("0 = two computers, 1 = one person and one computer, 2 = two people");
        int numberOfPlayers = s.nextInt();
        if(numberOfPlayers==0){
            p1.setAuto(true);
            p2.setAuto(true);        
        }else if(numberOfPlayers==1){
            p2.setAuto(true);
        }
        gameLoop(table, p1, p2, dominoBag, playerOneTurn, s);
    }
    
    public static void gameLoop(CTable table, CPlayer p1, CPlayer p2, CDominoes dominoBag, boolean playerOneTurn, Scanner s) {
        int passCounter = 0;
        while(p1.getPlayerHand().size() > 0 && p2.getPlayerHand().size() > 0 && passCounter < 2) {
            int choice = 0;
            if (playerOneTurn) {
                table.displayBoard();
                if(table.canPlay(p1.getPlayerHand())){
                    System.out.println("Player One, What domino will you play?");
                    table.displayHand(p1.getPlayerHand());
                    if(!p1.isAuto()){
                        choice = s.nextInt();
                        while(!table.playPiece(p1.getPlayerHand().get(choice))){
                            choice = s.nextInt();
                        }
                    }else {
                        choice = 0;
                        while(!table.playPiece(p1.getPlayerHand().get(choice))){
                            choice++;
                        }
                    }
                    p1.getPlayerHand().remove(choice);
                    playerOneTurn = !playerOneTurn;
                    passCounter = 0;
                }else{
                    if(dominoBag.canDraw()){
                        System.out.println("Player One doesn't have any dominoes they can play, drawing domino");
                        p1.drawDominoe(dominoBag.getDominoList());
                    }else{
                        playerOneTurn = !playerOneTurn;
                        if(passCounter == 1){
                            passCounter++;
                        }
                        passCounter++;
                    }
                }
            } else {
                table.displayBoard();
                if(table.canPlay(p2.getPlayerHand())){
                    System.out.println("Player Two, What domino will you play?");
                    table.displayHand(p2.getPlayerHand());
                    if(!p2.isAuto()){
                        choice = s.nextInt();
                        while(!table.playPiece(p2.getPlayerHand().get(choice))){
                            choice = s.nextInt();
                        }
                    }else {
                        choice = 0;
                        while(!table.playPiece(p2.getPlayerHand().get(choice))){
                            choice++;
                        }
                    }
                    p2.getPlayerHand().remove(choice);
                    playerOneTurn = !playerOneTurn;
                    passCounter = 0;
                }else{
                    if(dominoBag.canDraw()){
                        System.out.println("Player Two doesn't have any dominoes they can play, drawing domino");
                        p2.drawDominoe(dominoBag.getDominoList());
                    }else{
                        if(passCounter == 1){
                            passCounter++;
                        }
                        passCounter++;
                    }
                }
            }
        }
        //determine winner
        if(p1.getPlayerHand().size() == 0){
            //print win message
            System.out.println("Player One Won!");
        }else if(p2.getPlayerHand().size() == 0){
            //print win message
            System.out.println("Player Two Won!");            
        }else{            
            if(p1.getPlayerHand().size() > p2.getPlayerHand().size()){
                //print tie message
                System.out.println("Tie! Player Two had less dominoes in hand");
            }else if(p1.getPlayerHand().size() < p2.getPlayerHand().size()){
                //print tie message
                System.out.println("Tie! Player One had less dominoes in hand");
            }else{
                //print tie message
                System.out.println("Tie!");
            }
        }

    }
}
