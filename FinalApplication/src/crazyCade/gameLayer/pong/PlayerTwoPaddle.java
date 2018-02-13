/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;

import processing.core.PApplet;
import processing.serial.*;
/**
 *
 * @author Joe Moss
 */
public class  PlayerTwoPaddle extends PongPaddle{
    int playerPadX = 5, newByte, newY, padY;
    PApplet instance;
    boolean started = false;
    boolean pong = false;
    Serial myPort;
    
    
 public PlayerTwoPaddle(PApplet inst){
        instance = inst;
//        myPort = new Serial(instance, Serial.list()[0], 9600);
//        myPort.write("PONG\n");
    }
    public void gameOver(){
        myPort.stop();
    }
    public int getMove(){
        if(started == false){
            this.myPort = new Serial(instance, Serial.list()[1], 9600);
            
            started = true;
        }
//        for(int i=1; i<2; i++){
            this.myPort.write('P');
 //       }    
          
//        myPort.write("PONG\n");
        while(myPort.available() > 0){
            newByte = myPort.read();
            if(newByte != -1){
                //code for removing last character found here; https://www.leveluplunch.com/java/examples/remove-last-character-from-string/
//                String alteredByte = newByte.substring(0, newByte.length() - 2);
//                pentValue = Integer.valueOf(alteredByte);
                newY = (int) (newByte * 1.4);
//                println(alteredByte);
                System.out.println(newY);
                
                
            }
           
        }
        return newY;
    }
}


    
    