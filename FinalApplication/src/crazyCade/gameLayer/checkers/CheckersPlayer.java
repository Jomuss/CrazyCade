/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;
import processing.core.PApplet;
import processing.serial.*;
/**
 *
 * @author Joe Moss
 */
public class CheckersPlayer {
    private int newByte, lastByte, portNum, pawnsAlive, playerNum;
    Serial myPort;
    boolean started;
    PApplet inst;
    boolean validMoves[];
    CheckerManager manager;
    public CheckersPlayer(PApplet inst, int portNum, CheckerManager manager){
        pawnsAlive = 12;
        started = false;
        this.inst = inst;
        this.portNum = portNum;
        validMoves = new boolean[2];
        initializePawns();
        this.manager = manager;
    }
    
    public void initializePawns(){
        if(this.portNum == 2){
            this.playerNum = 1;
            for(int i=0; i<8; i++){
                for(int j=5; j<8; j++){
                    if(i%2 != 0 && j%2 != 0){
                        CheckerBoard.getBoard()[i][j] = 1;
                    }
                    else if(i%2 == 0 && j%2 ==0){
                        CheckerBoard.getBoard()[i][j] = 1;
                    }
                }
            }
        }
        else{
            this.playerNum = 2;
            for(int i=0; i<8; i++){
                for(int j=0; j<3; j++){
                    if(i%2 != 0 && j%2 != 0){
                        CheckerBoard.getBoard()[i][j] = 2;
                    }
                    else if(i%2 == 0 && j%2 ==0){
                        CheckerBoard.getBoard()[i][j] = 2;
                    }
                }
            }
        }
    }
    
    public int getValue(){
        for(int i=0; i<Serial.list().length;i++){
            System.out.println(Serial.list()[i]);
        }
        //If the Player has not yet had their first turn/innitiated contact with the Arduino
        if(started == false){
            this.myPort = new Serial(this.inst, Serial.list()[this.portNum], 9600);
            started = true;
        }
        char c = 'C';
        this.myPort.write(c);
        //Let the Arduino know that the game being played is chess
        
        while(myPort.available() > 0){
            lastByte = newByte;
            newByte = myPort.read();
            System.out.println(newByte);
            if((newByte != -1 && newByte != 'm') && newByte != 'c'){
                newByte = ((newByte)*(pawnsAlive - 1)/255 + 1);
                System.out.println(newByte);
            }else if(newByte != -1 && (char)newByte == 'c'){
                validMoves = manager.checkForValidMoves();
                System.out.println((char)newByte);
                if(validMoves[0] || validMoves[1]){
                    this.myPort.write('y');
                    manager.selectCurPawn = true;
                }
                else{
                    manager.noValidMovesNotif();
                }
            }else if((newByte != -1 && (char)newByte == 'm') && manager.selectCurPawn){
                manager.movePawn();
                System.out.println(newByte);
                
            }
        }
        return newByte;
    }
    
    public int getLastByte(){
        return lastByte;
    }
    public void losePawn(){
        this.pawnsAlive--;
    }
    public int getPawnsAlive(){
        return this.pawnsAlive;
    }
    public void gameOver(){
        myPort.stop();
    }
    
}
