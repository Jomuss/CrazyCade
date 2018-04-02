/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import crazyCade.modelLayer.PlayerModel;
import java.util.ArrayList;
import java.util.HashMap;
import processing.core.PApplet;
import processing.serial.*;

/**
 *
 * @author Joe Moss
 */
public class CheckersPlayer {
    PlayerModel player;
    HashMap<PawnPiece, CheckerSquare> PawnSet;  
    CheckerBoard board;
    PApplet inst;
    CheckersManager manager;
    Serial myPort;
    PawnPiece selectedPawn;
    boolean started = false;
    boolean selectCurPawn = false;
    boolean moveSelectedPawn = false;
    int portNum;
    int startingNum; 
    int newByte;
    int lastByte;
    int curNum;
    //Constructor to be used after implimenting account/leaderboard support
    public CheckersPlayer(PlayerModel player, PApplet inst, int portNum, CheckerBoard board, Runnable selectPawn, Runnable movePawn){
        this.board = board;
        this.player = player;
        this.inst = inst;
        this.portNum = portNum;
        startingNum = 12;
  
    }
    //Temporary Constructor  
    public CheckersPlayer( PApplet inst, CheckersManager manager, int portNum, CheckerBoard board){
        this.inst = inst;
        this.portNum = portNum;
        PawnSet = new HashMap();
        this.board = board;
        initializePawns();
        this.manager = manager;
    }
    public void movePawn(CheckerSquare oldSquare, CheckerSquare newSquare, PawnPiece selectedPiece){
        selectedPiece.x = newSquare.x+50;
        selectedPiece.y = newSquare.y+50;
        oldSquare.occupied = false;
        PawnSet.replace(selectedPiece, oldSquare, newSquare);
        newSquare.occupied = true;
        
    }
    private void pawnSelectedAlert(){
        
    }
    public void initializePawns(){
        if(this.portNum == 0){
            int curNum = board.getBoard().size()-1;
            int idCounter = 12;
            int counter = 0;
            for(int i = 8; i>5; i--){
                for(int k = 8;k>0;k--){
                    //If the pawn is on an even row
                    if(i%2 == 0 && k%2 == 0){
                        //100 is 1/8 the size of the gameboard, 50 is the offset so the center of the pawn is the centered in the sqaure
                        int y = (i*100)-50;
                        int x = (k*100)-50;
                        PawnPiece p = new PawnPiece(PawnPiece.black, x, y, idCounter); 
                        PawnSet.put(p, board.getBoard().get(curNum));
                        board.getBoard().get(curNum).occupied = true;
                        p.curPosition = board.getBoard().get(curNum);
                        counter++;
                        //In order to accurately keep track of the current square, the curNum is decremented by 3 on the edge of
                        //the game board and by 2 everywhere else
                        if(counter == 4){
                            curNum = curNum-3;
                        }
                        else{
                            curNum = curNum-2;
                        }
                        idCounter--;
                    }
                    //If the pawn is on an odd row
                    else if(i%2 !=0 && k%2 != 0){
                        //100 is 1/8 the size of the gameboard, 50 is the offset so the center of the pawn is centered in the square
                        int y = (i*100)-50;
                        int x = (k*100)-50;
                        PawnPiece p = new PawnPiece(PawnPiece.black, x, y, idCounter); 
                        PawnSet.put(p, board.getBoard().get(curNum));
                        board.getBoard().get(curNum).occupied = true;
                        p.curPosition = board.getBoard().get(curNum);
                        counter++;
                        //In order to accurately keep track of the current square, the curNum is decremented by 1 on the edge of
                        //the game board and by 2 everywhere else
                        if(counter == 8){
                            curNum--;
                        }
                        else{
                            curNum = curNum-2;
                        }
                        idCounter--;
                    }
                    
                }
            }
        }
        if(this.portNum == 1){
            int curNum = 0;
            int idCounter = 1;
            int counter = 0;
            for(int i = 0; i<3; i++){
                for(int k = 0;k<8;k++){
                    //If the pawn is on an even row
                    if(i%2 == 0 && k%2 == 0){
                        //100 is 1/8 the size of the gameboard, 50 is the offset so the center of the pawn is the centered in the sqaure
                        int y = (i*100)+50;
                        int x = (k*100)+50;
                        PawnPiece p = new PawnPiece(PawnPiece.white, x, y, idCounter); 
                        PawnSet.put(p, board.getBoard().get(curNum));
                        board.getBoard().get(curNum).occupied = true;
                        p.curPosition = board.getBoard().get(curNum);
                        counter++;
                        if(counter == 3)
                            curNum+=3;
                        else
                            curNum+=2;
                        idCounter++;
                    }
                    //If the pawn is on an odd row
                    if(i%2 != 0 && k%2 != 0){
                        //100 is 1/8 the size of the gameboard, 50 is the offset so the center of the pawn is the centered in the sqaure
                        int y = (i*100)+50;
                        int x = (k*100)+50;
                        PawnPiece p = new PawnPiece(PawnPiece.white, x, y, idCounter); 
                        PawnSet.put(p, board.getBoard().get(curNum));
                        board.getBoard().get(curNum).occupied = true;
                        p.curPosition = board.getBoard().get(curNum);
                        counter++;
                        if(counter == 7)
                            curNum++;
                        else
                            curNum+=2;
                        idCounter++;
                    }
                    
                }
            }
        }
    }
    public HashMap<PawnPiece, CheckerSquare> getPawns(){
        return PawnSet;
    }
    public int getValue(){
        //If the Player has not yet had their first turn/innitiated contact with the Arduino
        if(started == false){
            this.myPort = new Serial(inst, Serial.list()[portNum], 9600);
            started = true;
        }
        this.myPort.write('C');
        //Let the Arduino know that the game being played is chess
        
        while(myPort.available() > 0){
            lastByte = newByte;
            newByte = myPort.read();
            if((newByte != -1 && newByte != 'm') && newByte != 'c'){
                System.out.println(newByte);
            }else if(newByte != -1 && (char)newByte == 'c'){
                boolean validMoves[] = new boolean[2];
                validMoves = this.checkForValidMoves(lastByte);
                System.out.println((char)newByte);
                if(validMoves[0] || validMoves[1]){
                    this.myPort.write('y');
                    selectCurPawn = true;
                    manager.selectCurrentPawn();
                }
                else{
                    manager.noValidMovesNotif();
                }
            }else if(newByte != -1 && (char)newByte == 'm'){
                manager.movePawn();
                System.out.println(newByte);
                
            }
        }
        return newByte;
    }
    //Set the pawn that has been selected by the player
    public void setSelectedPawn(int curPawnID){
        for(PawnPiece p: PawnSet.keySet()){
            if(p.ID == curPawnID){
                selectedPawn = p;
            }
        }
    }
//    public PawnPiece getPawn(CheckerID ID){
//        PawnPiece p = PawnSet.get(ID);
//        for(PawnPiece piece: PawnSet.keySet()){
//            if()
//        }
//        
//    }
    //FOR USE EXTERNALLY
    public boolean[] checkForValidMoves(){
        boolean[] validMoves = new boolean[2];
        CheckerID[] potentialMoves = this.getPotentialMoves();
        CheckerSquare leftSquare = null;
        if(potentialMoves[0] != null)
            leftSquare = board.getSquareFromID(potentialMoves[0]);
        CheckerSquare rightSquare = null;
        if(potentialMoves[1] != null)
            rightSquare = board.getSquareFromID(potentialMoves[1]);
        if(leftSquare == null ||leftSquare.occupied)
            validMoves[0] = false;
        else
            validMoves[0] = true;   
        if(rightSquare == null || rightSquare.occupied)
            validMoves[1] = false;
        else{
            validMoves[1] = true; 
        }  
        return validMoves;
    }
    public CheckerID[] getPotentialMoves(){
        if(manager.getTurn() == 1){
            CheckerID[] potentialMoves = new CheckerID[2];
            potentialMoves[0] = new CheckerID((char)(PawnSet.get(selectedPawn).ID.getLetter()-1), (PawnSet.get(selectedPawn).ID.getNum()-1));
            System.out.println(potentialMoves[0].getLetter()+""+potentialMoves[0].getNum());
            potentialMoves[1] = new CheckerID((char)(PawnSet.get(selectedPawn).ID.getLetter()+1), (PawnSet.get(selectedPawn).ID.getNum())-1);
            System.out.println(potentialMoves[1].getLetter()+""+potentialMoves[1].getNum());
            return potentialMoves; 
        }
        else{
            CheckerID[] potentialMoves = new CheckerID[2];
            potentialMoves[0] = new CheckerID((char)(PawnSet.get(selectedPawn).ID.getLetter()-1), (PawnSet.get(selectedPawn).ID.getNum()+1));
            System.out.println(potentialMoves[0].getLetter()+""+potentialMoves[0].getNum());
            potentialMoves[1] = new CheckerID((char)(PawnSet.get(selectedPawn).ID.getLetter()+1), (PawnSet.get(selectedPawn).ID.getNum())+1);
            System.out.println(potentialMoves[1].getLetter()+""+potentialMoves[1].getNum());
            return potentialMoves; 
        }
    }
    //FOR USE INTERNALLY
    private boolean[] checkForValidMoves(int playerValue){
        boolean[] validMoves = new boolean[2];
        CheckerID[] potentialMoves = this.getPotentialMoves(playerValue);
        CheckerSquare leftSquare = null;
        if(potentialMoves[0] != null)
            leftSquare = board.getSquareFromID(potentialMoves[0]);
        CheckerSquare rightSquare = null;
        if(potentialMoves[1] != null)
            rightSquare = board.getSquareFromID(potentialMoves[1]);
        if(leftSquare == null ||leftSquare.occupied)
            validMoves[0] = false;
        else
            validMoves[0] = true;   
        if(rightSquare == null || rightSquare.occupied)
            validMoves[1] = false;
        else{
            validMoves[1] = true; 
        }  
        return validMoves;
    }
    private CheckerID[] getPotentialMoves(int playerValue){
        PawnPiece pawn = null;
        for(PawnPiece p: PawnSet.keySet()){
            if(p.ID == playerValue){
                pawn = p;
            }
        }
        if(manager.getTurn() == 1){
            CheckerID[] potentialMoves = new CheckerID[2];
            potentialMoves[0] = new CheckerID((char)(PawnSet.get(pawn).ID.getLetter()-1), (PawnSet.get(pawn).ID.getNum()-1));
            System.out.println(potentialMoves[0].getLetter()+""+potentialMoves[0].getNum());
            potentialMoves[1] = new CheckerID((char)(PawnSet.get(pawn).ID.getLetter()+1), (PawnSet.get(pawn).ID.getNum())-1);
            System.out.println(potentialMoves[1].getLetter()+""+potentialMoves[1].getNum());
            if(potentialMoves[0].getLetter() < 'A' || potentialMoves[0].getLetter() > 'H'){
                potentialMoves[0] = null;
            }
            if(potentialMoves[1].getLetter() < 'A' || potentialMoves[1].getLetter() > 'H'){
                potentialMoves[1] = null;
            }
            return potentialMoves; 
        }
        else{
            CheckerID[] potentialMoves = new CheckerID[2];
            potentialMoves[0] = new CheckerID((char)(PawnSet.get(pawn).ID.getLetter()-1), (PawnSet.get(pawn).ID.getNum()+1));
            System.out.println(potentialMoves[0].getLetter()+""+potentialMoves[0].getNum());
            potentialMoves[1] = new CheckerID((char)(PawnSet.get(pawn).ID.getLetter()+1), (PawnSet.get(pawn).ID.getNum())+1);
            System.out.println(potentialMoves[1].getLetter()+""+potentialMoves[1].getNum());
            if(potentialMoves[0].getLetter() < 'A' || potentialMoves[0].getLetter() > 'H'){
                potentialMoves[0] = null;
            }
            if(potentialMoves[1].getLetter() < 'A' || potentialMoves[1].getLetter() > 'H'){
                potentialMoves[1] = null;
            }
            return potentialMoves; 
        }
    }
    
}
