/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import java.util.ArrayList;

/**
 *
 * @author Joe Moss
 */
public class CheckerBoard {
    private ArrayList<CheckerSquare> checkerSquares;
    public CheckerBoard(){
        checkerSquares = new ArrayList();
        initializeBoard();
    }
    public ArrayList<CheckerSquare> getBoard(){
        return checkerSquares;
    }
    private void initializeBoard(){
        int letter = 65;
        int num = 1;
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
}
