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
public class PawnManager {
    public ArrayList<PawnPiece> pOnePawns;
    public ArrayList<PawnPiece> pTwoPawns;
    
    public PawnManager(){
        pOnePawns = new ArrayList();
        pTwoPawns = new ArrayList();
    }
}
