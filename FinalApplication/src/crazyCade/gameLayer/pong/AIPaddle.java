/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;

/**
 *
 * @author Joe Moss
 */
public class AIPaddle extends PongPaddle{
    int AIpadX = 5, AIpadY = 50, AICount = 0, AImaxCount = 15, AISpeed;
    private double moveProb = .75;
    void getMove(int ballY, int height){
        int yVal = 0;
        AICount++;
        if(AICount > AImaxCount){
            AISpeed = AIMovement(AIpadY, ballY, moveProb);
            if(AIpadY < 10){
                AIpadY = AIpadY + 1;
            }
            else if (AIpadY > height - 60){
                AIpadY = AIpadY - 1;
            }
            else{   
                AIpadY = AIpadY + AISpeed;
            }
            AICount = 0;
        }
        else{
            if(AIpadY < 10){
                AIpadY = AIpadY + 1;
            }
            else if (AIpadY > height - 60){
                AIpadY = AIpadY - 1;
            }
            else{   
                AIpadY = AIpadY + AISpeed;
            }
            
        }

        
    }
    private int AIMovement( int aiY, int ballY, double moveProb){
        double r = Math.random();
        
        if(r <= moveProb ){
            if(aiY - ballY > 0){
                return -5;
            }else
                return 5;   
        }else{
            if(aiY - ballY > 0){
                return 5;
            }else
                return -5;   
        }
    }
}
