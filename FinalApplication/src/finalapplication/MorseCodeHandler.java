/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalapplication;

import processing.core.PApplet;
import processing.serial.*;
/**
 *
 * @author Joe Moss
 */
public class MorseCodeHandler extends PApplet{
 
    boolean started = false;
    MorseSerialManager serialMan;
    

    public void init(){
        serialMan = new MorseSerialManager(this);
    }
    public void startPort(){
    }
    public MorseCodeHandler(){
        
    }
    public void setup(){
    }
    public void settings(){
 
      
    }
      public void sendString(String string){
        if(started == false){
//            this.myPort = new Serial(this, Serial.list()[0], 9600);
            MorseSerialManager.myPort.write('M');
            started = true;
        }
        MorseSerialManager.myPort.write(string);
    }
    
    
}
