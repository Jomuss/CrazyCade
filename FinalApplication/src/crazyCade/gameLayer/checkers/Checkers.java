/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import java.util.ArrayList;
import processing.core.PApplet;
import crazyCade.modelLayer.PlayerModel;

/**
 *
 * @author Joe Moss
 */
public class Checkers extends PApplet{
   private final CheckerBoard checkerBoard;
//    private PlayerModel playerOne;
//    private PlayerModel playerTwo;
    private final CheckersPlayer playerOne;
    private final CheckersPlayer playerTwo;
    private PawnManager pawnManager;
    
    
    
    public Checkers(){
        checkerBoard = new CheckerBoard();
        playerOne = new CheckersPlayer(this, 0, checkerBoard);
        playerTwo = new CheckersPlayer(this, 1, checkerBoard);
        
        
    }
    public void intialize(){
        PApplet.main("crazyCade.gameLayer.checkers.Checkers");
    }
    public void drawBoard(){              
        noStroke();
        for(CheckerSquare c:checkerBoard.getBoard()){
            fill(c.color[0], c.color[1], c.color[2]);
            if(mouseX > c.x && mouseX < c.x+c.width && mouseY > c.y && mouseY < c.y+c.height ){
                strokeWeight(4);
                stroke(250, 250, 0);
                System.out.println((char)(c.ID.getLetter())+""+(Integer)(c.ID.getNum()));
            }
            else{
                noStroke();
            }
            rect(c.x, c.y, c.width, c.height);
            

        }
    }
    public void drawPawns(){
        for(PawnPiece p: playerOne.getPawns()){
            fill(p.color[0], p.color[1], p.color[2]);
            ellipse(p.x, p.y, p.radius, p.radius);
        }
        for(PawnPiece p: playerTwo.getPawns()){
            fill(p.color[0], p.color[1], p.color[2]);
            ellipse(p.x, p.y, p.radius, p.radius);
        }
    }
    
    
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
        drawBoard();
        noStroke();
        drawPawns();
        
        
    }
   @Override
    public void mouseClicked(){
        
    }
    
}
