/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import java.util.ArrayList;
import processing.core.PApplet;
import crazyCade.modelLayer.PlayerModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Joe Moss
 */
public class CheckersManager extends PApplet{
   private final CheckerBoard checkerBoard;
//    private PlayerModel playerOne;
//    private PlayerModel playerTwo;
    private final CheckersPlayer playerOne;
    private final CheckersPlayer playerTwo;
    public CheckersPlayer currentPlayer;
    public CheckersPlayer standbyPlayer;
    private int currentPlayerValue;
    public enum TURN{
        ONE,
        TWO
    }
    TURN curTurn = TURN.ONE;
    private boolean pawnSelected = false;
    public boolean movePawn = false;
    private int newSquare;
    private CheckerSquare currentSquare;
    private CheckerSquare newSelectedSquare;
    
    
    public CheckersManager(){
        checkerBoard = new CheckerBoard();
        playerOne = new CheckersPlayer(this, this, 0, checkerBoard);
        playerTwo = new CheckersPlayer(this, this, 1, checkerBoard);
        currentPlayer = playerOne;
        
        
    }
    public int getTurn(){
        if(curTurn == TURN.ONE)
            return 1;
        else
            return 2;
    }
    public void intialize(){
        PApplet.main("crazyCade.gameLayer.checkers.CheckersManager");
    }
    public void drawBoard(){              
        noStroke();
        
        for(CheckerSquare c:checkerBoard.getBoard()){
            fill(c.color[0], c.color[1], c.color[2]);
            rect(c.x, c.y, c.width, c.height);
            

        }
    }
    public void changeTurn(){
        if(curTurn == TURN.ONE){
            curTurn = TURN.TWO;
            currentPlayer = playerTwo;
            standbyPlayer = playerOne;
        }else{
            curTurn = TURN.ONE;
            currentPlayer = playerOne;
            standbyPlayer = playerTwo;
        }
    }
    public void drawPawns(){
        for(PawnPiece p: playerOne.getPawns().keySet()){
            fill(p.color[0], p.color[1], p.color[2]);
            if(p.ID == currentPlayerValue && curTurn == TURN.ONE && currentPlayer.selectCurPawn == false){
                strokeWeight(4);
                stroke(200,200,200);
                System.out.println(p.curPosition.ID.getLetter()+""+p.curPosition.ID.getNum());
            }
            else if(p.ID == currentPlayerValue && curTurn == TURN.ONE && currentPlayer.selectCurPawn == true){
              strokeWeight(4); 
              stroke(0,0,200);
              System.out.println(p.curPosition.ID.getLetter()+""+p.curPosition.ID.getNum());
            }
            else{
                noStroke();
            }
            ellipse(p.x, p.y, p.radius, p.radius);
        }
        for(PawnPiece p: playerTwo.getPawns().keySet()){
            fill(p.color[0], p.color[1], p.color[2]);
            if(p.ID == currentPlayerValue && curTurn == TURN.TWO && currentPlayer.selectCurPawn == false){
                strokeWeight(4);
                stroke(25,25,25);
                System.out.println(p.curPosition.ID.getLetter()+""+p.curPosition.ID.getNum());
            }
            else if(p.ID == currentPlayerValue && curTurn == TURN.TWO && currentPlayer.selectCurPawn == true){
              strokeWeight(4); 
              stroke(0,0,25);
              System.out.println(p.curPosition.ID.getLetter()+""+p.curPosition.ID.getNum());
            }
            else{
                noStroke();
            }
            ellipse(p.x, p.y, p.radius, p.radius);
        }
    }
    
    public void noValidMovesNotif(){
        JOptionPane.showMessageDialog(null, "There are no valid moves for this Pawn, please select another", "Oh No!", 0);
    }

    public void drawPotentialMoves(){
        boolean[] validMoves = new boolean[2];
        CheckerID[] potentialMoves = new CheckerID[2];
        potentialMoves = currentPlayer.getPotentialMoves();
        validMoves = currentPlayer.checkForValidMoves();
        for(CheckerSquare c:checkerBoard.getBoard()){
            if(c.ID.getLetter() == potentialMoves[0].getLetter() && c.ID.getNum() == potentialMoves[0].getNum() &&
                    newSquare == 1&& validMoves[0]){
                fill(c.color[0], c.color[1], c.color[2]);
                strokeWeight(6);
                stroke(200,200,200);
                rect(c.x, c.y, c.width, c.height);
            }
            else if(c.ID.getLetter() == potentialMoves[0].getLetter() && c.ID.getNum() == potentialMoves[0].getNum() &&
                    newSquare == 0 && validMoves[0]){
                fill(c.color[0], c.color[1], c.color[2]);
                strokeWeight(6);
                stroke(255,255,0);
                rect(c.x, c.y, c.width, c.height);
                newSelectedSquare = c;
 
            }
            else if(c.ID.getLetter() == potentialMoves[1].getLetter() && c.ID.getNum() == potentialMoves[1].getNum() &&
                    newSquare == 0&& validMoves[0]){
                fill(c.color[0], c.color[1], c.color[2]);
                strokeWeight(6);
                stroke(200,200,200);
                rect(c.x, c.y, c.width, c.height);

            }
            else if(c.ID.getLetter() == potentialMoves[1].getLetter() && c.ID.getNum() == potentialMoves[1].getNum() &&
                    newSquare == 1 && validMoves[1]){
                fill(c.color[0], c.color[1], c.color[2]);
                strokeWeight(6);
                stroke(255,255,0);
                rect(c.x, c.y, c.width, c.height);
                newSelectedSquare = c;

            }
            
        }
    }
    public void movePawn(){
        currentPlayer.movePawn(currentSquare, newSelectedSquare, currentPlayer.selectedPawn);
        currentPlayer.selectCurPawn = false;
        changeTurn();
        pawnSelected = false;
    }
    public void selectCurrentPawn(){
        pawnSelected = true;
        currentPlayer.setSelectedPawn(currentPlayerValue);
        currentSquare = currentPlayer.PawnSet.get(currentPlayer.selectedPawn);
    }
    public void getPlayerData(){
            if(currentPlayer.selectCurPawn == false){
                currentPlayerValue = currentPlayer.getValue();
            }
            else if(currentPlayer.selectCurPawn == true && pawnSelected == false){
                if(currentPlayerValue == 115 || currentPlayerValue == 109){
                    currentPlayerValue = currentPlayer.getValue();

                }
                else{
                    currentPlayerValue = currentPlayerValue;
                    currentPlayer.setSelectedPawn(currentPlayerValue);
                    pawnSelected = true;

                }
            }
            else if(pawnSelected){
                newSquare = currentPlayer.getValue();
                if(newSquare>=6 && currentPlayer.validMoves[1]){
                    newSquare = 1;
                }else if(newSquare>=6 && !currentPlayer.validMoves[1]){
                    newSquare = 0;
                }else if(newSquare<6 && currentPlayer.validMoves[0]){
                    newSquare = 0;
                }
                }else if(newSquare<6 && !currentPlayer.validMoves[0]){
                    newSquare = 1;
                }
                System.out.println(newSquare);
            }
//    public void getPlayerData(){
//        //IF IT IS PLAYER ONE'S TURN
//        if(curTurn == TURN.ONE){
//            if(playerOne.selectCurPawn == false){
//                playerOneValue = playerOne.getValue();
//            }
//            else if(playerOne.selectCurPawn == true && pawnSelected == false){
//                if(playerOneValue == 115 || playerOneValue == 109){
//                    playerOneValue = playerOne.getValue();
//
//                }
//                else{
//                    playerOneValue = playerOneValue;
//                    playerOne.setSelectedPawn(playerOneValue);
//                    pawnSelected = true;
//
//                }
//            }
//            else if(pawnSelected){
//                newSquare = playerOne.getValue();
//                if(newSquare>6){
//                    newSquare = 1;
//                }else{
//                    newSquare = 0;
//                }
//                System.out.println(newSquare);
//            }
//        }
//        //ELSE IF IT IS PLAYER TWO'S TURN
//        else if (curTurn == TURN.TWO){
//            if(playerTwo.selectCurPawn == false ){
//                playerTwoValue = playerTwo.getValue();
//            }
//            else if(playerTwo.selectCurPawn == true && pawnSelected == false){
//                if(playerTwoValue == 115){
//                    playerTwoValue = playerTwo.getValue();
//
//                }
//                else{
//                    playerTwoValue = playerTwoValue;
//                    playerTwo.setSelectedPawn(playerTwoValue);
//                    pawnSelected = true;
//               }
//            }
//            else if(pawnSelected){
//                newSquare = playerTwo.getValue();
//                if(newSquare>6){
//                    newSquare = 1;
//                }else{
//                    newSquare = 0;
//                }
//                System.out.println(newSquare);
//            }
//        }
//    }
        
   @Override
    public void settings(){
         size(800, 800);
    }

   @Override
    public void setup(){
//        myPort = new SerialHandler();
    }
   @Override
    public void draw(){
        
        getPlayerData();
        drawBoard();
        if(pawnSelected){
            drawPotentialMoves();
        }
        noStroke();
        drawPawns();
        
        
    }
   @Override
    public void mouseClicked(){
        
    }
    
}
