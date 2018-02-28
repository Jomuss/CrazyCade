/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import java.awt.Color;

/**
 *
 * @author Joe Moss
 */
public class CheckerSquare {
    public int width;
    public int height;
    public CheckerID ID;
    public int[] color;
    public int x;
    public int y;
    public static int[] red = {255,0,0};
    public static int[] black = {0,0,0};
    
    
    CheckerSquare(char IDletter, int IDnum, int[] color, int x, int y){
        width = 100;
        height = 100;
        this.ID = new CheckerID();
        this.ID.setLetter(IDletter);
        this.ID.setNum(IDnum);
        this.color = color;
        this.x = x;
        this.y = y;
    }
    
}
