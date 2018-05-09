/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

/**
 *
 * @author Joe Moss
 */
public class CheckerBoard {
    private int checkerBoard[][];
    private static CheckerBoard theInstance = null;
    
    private CheckerBoard(){
        checkerBoard = new int[8][8];
        intitializeBoard();
        
    }
    public static CheckerBoard getInstance(){
        if(theInstance == null){
            theInstance = new CheckerBoard();
        }
        return theInstance;
    }
    private void intitializeBoard(){
        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++){
                checkerBoard[i][j] = 0;
            }
        }
        
    }
    
    public static int[][] getBoard(){
        if(theInstance == null){
            theInstance = new CheckerBoard();
        }
        return theInstance.checkerBoard;
    }
    public static void resetBoard(){
        for(int i=0; i<7; i++){
            for(int j=0; j<7; j++){
                CheckerBoard.getBoard()[i][j] = 0;
            }
        }
    }
}
