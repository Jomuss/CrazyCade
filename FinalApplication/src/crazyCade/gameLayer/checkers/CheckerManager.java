/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import javax.swing.JOptionPane;
import processing.core.PApplet;

/**
 *
 * @author Joe Moss
 */
public class CheckerManager extends PApplet{

    CheckersPlayer playerOne;
    CheckersPlayer playerTwo;
    private int curTurn;
    private final int ONE = 1;
    private final int TWO = 2;
    private int selectedPawnCounter, pOneVal, pTwoVal;
    private int leftMoveCoordinates[];
    private int rightMoveCoordinates[];
    public boolean selectCurPawn, highlightLeft, highlightRight, jumpLeft, jumpRight;
    private int curPawnCoordinates[];
    
    
    public CheckerManager(){
        playerOne = new CheckersPlayer(this, 0, this);
        playerTwo = new CheckersPlayer(this, 1, this);
        curTurn = ONE;
        selectedPawnCounter = 0;
        leftMoveCoordinates = new int[2];
        rightMoveCoordinates = new int[2];
        curPawnCoordinates = new int[2];
        selectCurPawn = false;
        highlightLeft = false;
        highlightRight = false;
        jumpLeft = false;
        jumpRight = false;
    }
    
    /**
     *
     */
    public void initialize() {
        PApplet.main("crazyCade.gameLayer.checkers.CheckerManager");
    }
   
    @Override
    public void settings(){
         size(1000, 850);
    }

   @Override
    public void setup(){

    }
    public void gameOver(){
        if(playerOne.getPawnsAlive() == 0){
            JOptionPane.showMessageDialog(null, "Congratulations Player Two, you win!", "Yay!", 0);
        }
        else{
            JOptionPane.showMessageDialog(null, "Congratulations Player One, you win!", "Yay!", 0);
        }
        surface.setVisible(false);
    }
    public void noValidMovesNotif(){
        JOptionPane.showMessageDialog(null, "There are no valid moves for this Pawn, please select another", "Oh No!", 0);
    }
    private void changeTurn(){
        if(curTurn == ONE)
            curTurn = TWO;
        else
            curTurn = ONE;
    }
    public void movePawn(){
        if(curTurn == ONE){
            if(highlightLeft){
                CheckerBoard.getBoard()[leftMoveCoordinates[0]][leftMoveCoordinates[1]] = 1;
                CheckerBoard.getBoard()[curPawnCoordinates[0]][curPawnCoordinates[1]] = 0;
                if(jumpLeft){
                    CheckerBoard.getBoard()[leftMoveCoordinates[0]+1][leftMoveCoordinates[1]+1] = 0;
                    playerTwo.losePawn();
                    jumpLeft = false;
                }
                selectCurPawn = false;
 
            }
            if(highlightRight){
                CheckerBoard.getBoard()[rightMoveCoordinates[0]][rightMoveCoordinates[1]] = 1;
                CheckerBoard.getBoard()[curPawnCoordinates[0]][curPawnCoordinates[1]] = 0;
                if(jumpRight){
                    CheckerBoard.getBoard()[rightMoveCoordinates[0]-1][rightMoveCoordinates[1]+1] = 0;
                    playerTwo.losePawn();
                    jumpRight = false;
                }
                selectCurPawn = false;
 
            }
        }else{
            if(highlightLeft){
                CheckerBoard.getBoard()[leftMoveCoordinates[0]][leftMoveCoordinates[1]] = 2;
                CheckerBoard.getBoard()[curPawnCoordinates[0]][curPawnCoordinates[1]] = 0;
                if(jumpLeft){
                    CheckerBoard.getBoard()[leftMoveCoordinates[0]+1][leftMoveCoordinates[1]-1] = 0;
                    playerOne.losePawn();
                    jumpLeft = false;
                }
                selectCurPawn = false;
 
            }
            if(highlightRight){
                CheckerBoard.getBoard()[rightMoveCoordinates[0]][rightMoveCoordinates[1]] = 2;
                CheckerBoard.getBoard()[curPawnCoordinates[0]][curPawnCoordinates[1]] = 0;
                if(jumpRight){
                    CheckerBoard.getBoard()[rightMoveCoordinates[0]-1][rightMoveCoordinates[1]-1] = 0;
                    playerOne.losePawn();
                    jumpRight = false;
                }
                selectCurPawn = false;
 
            }
        
        }
        changeTurn();
    }
    private void drawBoard(){
        selectedPawnCounter = 0;
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                if(i%2 == 0 && j%2 == 0){
                     fill(255, 0, 0);
                     rect(i*100, j*100, 100, 100);
                }
                else if(i%2 == 0 && j%2 !=0){
                    fill(0, 0, 0);
                    rect(i*100, j*100, 100, 100);
                }
                else if (i%2 !=0 && j%2 == 0){
                    fill(0, 0, 0);
                    rect(i*100, j*100, 100, 100);
                }
                else{
                    fill(255, 0, 0);
                    rect(i*100, j*100, 100, 100);
                }
                textSize(15);
                fill(255,255,255);
                text((i+"-"+j), (i*100), (j*100)+100);
                if(CheckerBoard.getBoard()[i][j] == 1){
                    if(curTurn == ONE && !selectCurPawn){
                        selectedPawnCounter++;
                        if(selectedPawnCounter == pOneVal){
                            strokeWeight(7);
                            stroke(255, 255, 0);
                            curPawnCoordinates[0] = i;
                            curPawnCoordinates[1] = j;
                        }
                    }
                    
                    fill(0,0,0);
                    ellipse((i*100)+50, (j*100)+50, 75, 75);
                    noStroke();
                }
                else if(CheckerBoard.getBoard()[i][j] == 2){
                    if(curTurn == TWO && !selectCurPawn){
                        selectedPawnCounter++;
                        if(selectedPawnCounter == pTwoVal){
                            strokeWeight(7);
                            stroke(255, 255, 0);
                            curPawnCoordinates[0] = i;
                            curPawnCoordinates[1] = j;
                        }
                    }
                    fill(200,200,200);
                    ellipse((i*100)+50, (j*100)+50, 75, 75);
                    noStroke();
                }
                
            }
        }
        if(selectCurPawn){
            if(highlightLeft){
                stroke(240, 240, 0);
                fill(255, 0, 0);
                rect(leftMoveCoordinates[0]*100, leftMoveCoordinates[1]*100, 100, 100);
                noStroke();
            }
            else{
                stroke(240, 240, 0);
                fill(255, 0, 0);
                rect(rightMoveCoordinates[0]*100, rightMoveCoordinates[1]*100, 100, 100);
                noStroke();
            }
        }
    }
    public boolean[] checkForValidMoves(){
        boolean validMoves[] = new boolean[2];
        if(curTurn == ONE){
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(curPawnCoordinates[0] == i && curPawnCoordinates[1] == j){
                        //CheckLeft
                        if(((i-1) >= 0 && (i-1) < CheckerBoard.getBoard().length)
                        && (j-1) >= 0 && (j-1) < CheckerBoard.getBoard().length){
                            if(CheckerBoard.getBoard()[i-1][j-1] == 0){
                                validMoves[0] = true;
                                leftMoveCoordinates[0] = i-1;
                                leftMoveCoordinates[1] = j-1;

                            }
                            else if(CheckerBoard.getBoard()[i-1][j-1] == 1){
                                validMoves[0] = false;
                            }
                            else if(CheckerBoard.getBoard()[i-1][j-1] == 2){
                                if(((i-2) >= 0 && (i-2) < CheckerBoard.getBoard().length)
                                && (j-2) >= 0 && (j-2) < CheckerBoard.getBoard().length){
                                    if(CheckerBoard.getBoard()[i-2][j-2] == 0){
                                        validMoves[0] = true;
                                        leftMoveCoordinates[0] = i-2;
                                        leftMoveCoordinates[1] = j-2;
                                        jumpLeft = true;
                                    }
                                    
                                }
                                else{
                                    validMoves[0] = false;
                                }
                            }
                        }
                        else{
                            validMoves[0] = false;
                        }
                        //CheckRight
                        if(((i+1) >= 0 && (i+1) < CheckerBoard.getBoard().length)
                        && (j-1) >= 0 && (j-1) < CheckerBoard.getBoard().length){
                            if(CheckerBoard.getBoard()[i+1][j-1] == 0){
                                validMoves[1] = true;
                                rightMoveCoordinates[0] = i+1;
                                rightMoveCoordinates[1] = j-1;

                            }
                        
                           if(CheckerBoard.getBoard()[i+1][j-1] == 1){
                                validMoves[1] = false;
                            }
                            else if(CheckerBoard.getBoard()[i+1][j-1] == 2){
                                if(((i+2) >= 0 && (i+2) < CheckerBoard.getBoard().length)
                                && (j-2) >= 0 && (j-2) < CheckerBoard.getBoard().length){
                                    if(CheckerBoard.getBoard()[i+2][j-2] == 0){
                                        validMoves[1] = true;
                                        rightMoveCoordinates[0] = i+2;
                                        rightMoveCoordinates[1] = j-2;
                                        jumpRight = true;
                                    }
                                    
                                }else{
                                    validMoves[1] = false;
                                }
                            }
                        }
                        else{
                            validMoves[1] = false;
                        }
                        
                    }
                }
            }
        }else{
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    if(curPawnCoordinates[0] == i && curPawnCoordinates[1] == j){
                        //CheckLeft
                        if(((i-1) >= 0 && (i-1) < CheckerBoard.getBoard().length)
                        && (j+1) >= 0 && (j+1) < CheckerBoard.getBoard().length){
                            if(CheckerBoard.getBoard()[i-1][j+1] == 0){
                                validMoves[0] = true;
                                leftMoveCoordinates[0] = i-1;
                                leftMoveCoordinates[1] = j+1;

                            }
                            else if(CheckerBoard.getBoard()[i-1][j+1] == 2){
                                validMoves[0] = false;
                            }
                            else if(CheckerBoard.getBoard()[i-1][j+1] == 1){
                                if(((i-2) >= 0 && (i-2) < CheckerBoard.getBoard().length)
                                && (j+2) >= 0 && (j+2) < CheckerBoard.getBoard().length){
                                    if(CheckerBoard.getBoard()[i-2][j+2] == 0){
                                        validMoves[0] = true;
                                        leftMoveCoordinates[0] = i-2;
                                        leftMoveCoordinates[1] = j+2;
                                        jumpLeft = true;
                                    }
                                    
                                }
                                else{
                                    validMoves[0] = false;
                                }
                            }
                        }
                        else{
                            validMoves[0] = false;
                        }
                        //CheckRight
                        if(((i+1) >= 0 && (i+1) < CheckerBoard.getBoard().length)
                        && (j+1) >= 0 && (j+1) < CheckerBoard.getBoard().length){
                            if(CheckerBoard.getBoard()[i+1][j+1] == 0){
                                validMoves[1] = true;
                                rightMoveCoordinates[0] = i+1;
                                rightMoveCoordinates[1] = j+1;

                            }
                        
                           if(CheckerBoard.getBoard()[i+1][j+1] == 2){
                                validMoves[1] = false;
                            }
                            else if(CheckerBoard.getBoard()[i+1][j+1] == 1){
                                if(((i+2) >= 0 && (i+2) < CheckerBoard.getBoard().length)
                                && (j+2) >= 0 && (j+2) < CheckerBoard.getBoard().length){
                                    if(CheckerBoard.getBoard()[i+2][j+2] == 0){
                                        validMoves[1] = true;
                                        rightMoveCoordinates[0] = i+2;
                                        rightMoveCoordinates[1] = j+2;
                                        jumpRight = true;
                                    }
                                    
                                }else{
                                    validMoves[1] = false;
                                }
                            }
                        }
                        else{
                            validMoves[1] = false;
                        }
                        
                    }
                }
            }
            
        }
        return validMoves;
    }
    public void moveSelector(int curTurn){
        
        if(curTurn == ONE){
            pOneVal = playerOne.getValue();
            if(selectCurPawn){
                if(pOneVal <= (playerOne.getPawnsAlive()/2) && checkForValidMoves()[0]){
                    highlightLeft = true;
                    highlightRight = false;
                   
                }else if(pOneVal <= (playerOne.getPawnsAlive()/2) && !checkForValidMoves()[0]){
                    highlightLeft = false;
                    highlightRight = true;
                    
                }
                else if(pOneVal > (playerOne.getPawnsAlive()/2) && checkForValidMoves()[1]){
                    highlightLeft = false;
                    highlightRight = true;
                }
                else{
                    highlightLeft = true;
                    highlightRight = false;
                }
            }
        }else{
            pTwoVal = playerTwo.getValue();
            if(selectCurPawn){
                if(pTwoVal <= (playerTwo.getPawnsAlive()/2) && checkForValidMoves()[0]){
                    highlightLeft = true;
                    highlightRight = false;
                    
                }else if(pTwoVal <= (playerTwo.getPawnsAlive()/2) && !checkForValidMoves()[0]){
                    highlightLeft = false;
                    highlightRight = true;
                    
                }
                if(pTwoVal > (playerTwo.getPawnsAlive()/2) && checkForValidMoves()[1]){
                    highlightLeft = false;
                    highlightRight = true;
                }
                else{
                    highlightLeft = true;
                    highlightRight = false;
                }
            }
        }
    }
   @Override
    public void draw(){
        background(100);
        drawBoard();
        if(curTurn == ONE){
            moveSelector(curTurn);
        }else{
            moveSelector(curTurn);
        }
        if(playerOne.getPawnsAlive() == 0 || playerTwo.getPawnsAlive() == 0){
            gameOver();
        }
        
        textSize(24);
        fill(255,255,255);
        text("Current Turn: "+curTurn, 800, 30);
        textSize(20);
        text("Player One Score: "+playerOne.getPawnsAlive(), 800, 100);
        text("Player Two Score: "+playerTwo.getPawnsAlive(), 800, 200);
        
    }
    
    
}
