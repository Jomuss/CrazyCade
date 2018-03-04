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
public class PawnPiece {
    public int[] color;
    public int radius;
    int x;
    int y;
    public CheckerSquare curPosition;
    public static int[] white = {200,200,200};
    public static int[] black = {25,25,25};
    public boolean selected = false;
    
    
    public PawnPiece(int[] color, int x, int y){
        radius = 75;
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
