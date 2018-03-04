/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import crazyCade.modelLayer.PlayerModel;
import java.util.ArrayList;
import processing.core.PApplet;
import processing.serial.*;

/**
 *
 * @author Joe Moss
 */
public class CheckersPlayer {
    PlayerModel player;
    ArrayList<PawnPiece> pawnSet;
    CheckerBoard board;
    PApplet inst;
    int portNum;
    int startingNum; 
    int curNum;
    public CheckersPlayer(PlayerModel player, PApplet inst, int portNum, CheckerBoard board){
        this.board = board;
        this.player = player;
        this.inst = inst;
        this.portNum = portNum;
        pawnSet = new ArrayList();
        startingNum = 12;
    }
    public CheckersPlayer( PApplet inst, int portNum, CheckerBoard board){
        this.inst = inst;
        this.portNum = portNum;
        pawnSet = new ArrayList();
        this.board = board;
        initializePawns();
    }
    public void initializePawns(){
        int curNum = board.getBoard().size();
        if(this.portNum == 0){
            for(int i = 8; i>5; i--){
                for(int k = 8;k>0;k--){
//                    if(board.getBoard().get(curNum).ID.getNum()%2 == 0 
//                            && (board.getBoard().get(curNum).ID.getLetter()%2 == 0)){
                    if(i%2 == 0 && k%2 == 0){
                        int y = (i*100)-50;
                        int x = (k*100)-50;
                        PawnPiece p = new PawnPiece(PawnPiece.black, x, y); 
                        pawnSet.add(p);
                    }
                    if(i%2 !=0 && k%2 != 0){
                        int y = (i*100)-50;
                        int x = (k*100)-50;
                        PawnPiece p = new PawnPiece(PawnPiece.black, x, y); 
                        pawnSet.add(p);
                    }
                }
            }
        }
        if(this.portNum == 1){
            for(int i = 0; i<3; i++){
                for(int k = 0;k<8;k++){
//                    if(board.getBoard().get(curNum).ID.getNum()%2 == 0 
//                            && (board.getBoard().get(curNum).ID.getLetter()%2 == 0)){
                    if(i%2 == 0 && k%2 == 0){
                        int y = (i*100)+50;
                        int x = (k*100)+50;
                        PawnPiece p = new PawnPiece(PawnPiece.white, x, y); 
                        pawnSet.add(p);
                    }
                    if(i%2 != 0 && k%2 != 0){
                        int y = (i*100)+50;
                        int x = (k*100)+50;
                        PawnPiece p = new PawnPiece(PawnPiece.white, x, y); 
                        pawnSet.add(p);
                    }
                }
            }
        }
    }
    public ArrayList<PawnPiece> getPawns(){
        return pawnSet;
    }
    public void getMove(){
        
    }
    
}
