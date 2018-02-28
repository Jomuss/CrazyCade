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
    private ArrayList<CheckerSquare> checkerSquares;
//    private PlayerModel playerOne;
//    private PlayerModel playerTwo;
    private CheckersPlayer playerOne;
    private CheckersPlayer playerTwo;
    private PawnManager pawnManager;
    
    
    
    public Checkers(){
        checkerSquares = new ArrayList();
        
    }
    public void intialize(){
        PApplet.main("crazyCade.gameLayer.checkers.Checkers");
    }
    public void drawBoard(){              
        int letter = 65;
        int num = 1;
        noStroke();
        if(checkerSquares.isEmpty()){
            for(int i = 0; i < 8; i++){
                for(int k = 0; k < 8; k++){
                    if(i%2 == 0 && k%2 == 0){
                        checkerSquares.add(new CheckerSquare((char)(letter+i), (num+k), CheckerSquare.red, i*100, k*100));    
                    }
                    else if(i%2 == 0 && k%2 !=0){
                        checkerSquares.add(new CheckerSquare((char)(letter+i), (num+k), CheckerSquare.black, i*100, k*100));
                    }
                    else if (i%2 !=0 && k%2 == 0){
                        checkerSquares.add(new CheckerSquare((char)(letter+i), (num+k), CheckerSquare.black, i*100, k*100));
                    }
                    else{
                        checkerSquares.add(new CheckerSquare((char)(letter+i), (num+k), CheckerSquare.red, i*100, k*100));
                    }
                    
                }
            }
        }
        for(CheckerSquare c:checkerSquares){
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
        
    }
    
    public void settings(){
         size(800, 800);
    }

    public void setup(){
//        myPort = new SerialHandler();
    }
    public void draw(){
        drawBoard();
        
        
    }
    
}
