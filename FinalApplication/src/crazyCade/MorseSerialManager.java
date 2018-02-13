/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade;
import processing.serial.*;
import processing.core.PApplet;


/**
 *
 * @author Joe Moss
 */
public class MorseSerialManager{
    static Serial myPort;
    
    public MorseSerialManager(PApplet inst){
        myPort = new Serial(inst, Serial.list()[0], 9600);
    }
    public void setup(){
    }
    public void settings(){
 
      
    }
}
