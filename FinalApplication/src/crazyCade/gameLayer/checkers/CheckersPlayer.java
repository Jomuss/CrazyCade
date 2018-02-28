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
    Serial inst;
    int portNum;
    
    public CheckersPlayer(PlayerModel player, Serial inst, int portNum){
        this.player = player;
        this.inst = inst;
        this.portNum = portNum;
        pawnSet = new ArrayList();
    }
    public CheckersPlayer( Serial inst, int portNum){
        this.inst = inst;
        this.portNum = portNum;
        pawnSet = new ArrayList();
    }
    public void initializePawns(){
        if(this.portNum == 0){
            
        }
    }
    
    public void getMove(){
        
    }
    
}
