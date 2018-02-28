/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

import crazyCade.modelLayer.PlayerModel;
import processing.core.PApplet;
import processing.serial.*;

/**
 *
 * @author Joe Moss
 */
public class CheckersPlayerTwo {
    PlayerModel player;
    Serial port;
    
    CheckersPlayerTwo(PlayerModel player, Serial inst){
        this.player = player;
        port = inst;
    }
    
}
