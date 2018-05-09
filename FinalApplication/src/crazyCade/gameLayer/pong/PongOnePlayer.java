/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;



import processing.core.PApplet;
import java.util.Random;




/**
 *
 * @author     Joe Moss
 Reference used for Processing/PongOnePlayer: http://drdoane.com/thinking-through-a-basic-pong-game-in-processing/
 */

class AIScore{
    int score = 0;
}
class PlayerScore{
    int score = 0;
}
public class PongOnePlayer extends PApplet{
    boolean playingPong = true;
    PApplet inst = this;
    Random rand;
    PlayerOnePaddle playerPaddle;
    AIPaddle AIpad;
    Ball ball;
    PongOnePlayerSelector selector;
    PlayerScore PlayerScore;
    AIScore AIScore;

//    private int ballX = 75, ballY = 75, ballDiameter = 30, ballRadius = 15;
//    private int ballSpeedX = (rand.nextInt(2)+2), ballSpeedY = (rand.nextInt(2)-4);
//    private int padHeight = 50, padWidth = 20, playerPadX, playerPadY = 50;
//    private int AIpadX = 5, AIpadY = 50, AICount = 0, AImaxCount = 15, AISpeed;
//    private double moveProb = .75;
    private int pentValue;
    int newY = 0;
    
    /**
     * @param args the command line arguments
     */
    public PongOnePlayer(){
        rand = new Random();
        AIpad = new AIPaddle();
        ball = new Ball();
        PlayerScore = new PlayerScore();
        AIScore = new AIScore();
        playerPaddle = new PlayerOnePaddle(this);

        
//        print(SerialHandler.list());
//        myPort = new SerialHandler(this, SerialHandler.list()[0], 9600);
          
    }
    public PongOnePlayer(PongOnePlayerSelector inst){
        selector = inst;
    }
    public void initialize(PongOnePlayerSelector inst){

        PApplet.main("crazyCade.gameLayer.pong.PongOnePlayer");

    }
     public void settings(){
         size(500, 400);
    }

    public void setup(){
//        myPort = new SerialHandler();
    }

    public void draw(){
        background(200, 200, 200);
        if(AIScore.score < 11 && PlayerScore.score < 11){
            playerPaddle.padY = playerPaddle.getMove();

            fill(ball.red, ball.green, ball.blue);
            ellipse(ball.ballX, ball.ballY, ball.ballDiameter, ball.ballDiameter);

            fill(PongOnePlayerSelector.red, PongOnePlayerSelector.green, PongOnePlayerSelector.blue);
            rect(playerPaddle.playerPadX, playerPaddle.padY, playerPaddle.padWidth, playerPaddle.padHeight);

            fill(PongOnePlayerSelector.AIred, PongOnePlayerSelector.AIgreen, PongOnePlayerSelector.AIblue);
            rect(AIpad.AIpadX, AIpad.AIpadY, AIpad.padWidth, PongOnePlayerSelector.AIpadHeight);

            ball.ballMovement(playerPaddle, AIpad, height, width, AIScore, PlayerScore);
            AIpad.getMove(ball.ballY, height);

            textSize(32);
            fill(0,0,0);
            text(AIScore.score, 75, 30, 0);
            text(PlayerScore.score, 400, 30, 0);
        }
        else if(AIScore.score >= 11){
            textSize(35);
            fill(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            text("Sorry, You Lose!", 0, height*1/2);
            textSize(50);
            text("Thanks for Playing!", 0, height*2/3);
            playerPaddle.gameOver();

//            selector.setVisible(true);
            
            
        }
        else{
            textSize(35);
            fill(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            text("Congratulations, You Win!", 0, height*1/2);
            textSize(50);
            text("Thanks for Playing!", 0, height*2/3);
            playerPaddle.gameOver();

//            selector.setVisible(true);
        }
        
        
        
                //Based on code from https://processing.org/reference/keyCode.html
//        if (key == CODED) {
//            if (keyCode == UP) {
//                if(playerPadY < 10)
//                    playerPadY = playerPadY;
//                else
//                    playerPadY = playerPadY - 5;
//            }else if (keyCode == DOWN) {
//                if(playerPadY > height -60)
//                    playerPadY = playerPadY;
//                else
//                    playerPadY = playerPadY + 5;
//                
//            }
//        else
//            playerPadY = playerPadY;
//        }
        
//        AICount++;
//        if(AICount > AImaxCount){
//            AISpeed = AIMovement(AIpadY, ballY, moveProb);
//            if(AIpadY < 10){
//                AIpadY = AIpadY + 1;
//            }
//            else if (AIpadY > height - 60){
//                AIpadY = AIpadY - 1;
//            }
//            else{   
//                AIpadY = AIpadY + AISpeed;
//            }
//            AICount = 0;
//        }
//        else{
//            if(AIpadY < 10){
//                AIpadY = AIpadY + 1;
//            }
//            else if (AIpadY > height - 60){
//                AIpadY = AIpadY - 1;
//            }
//            else{   
//                AIpadY = AIpadY + AISpeed;
//            }
//            
//        }
//        if(ballX > width){
//            ballX = (int) (width*.5);
//            ballSpeedX = -ballSpeedX;
//            AIScore++;
//        }else if(ballX < 0){
//            ballX = (int) (width*.5);
//            ballSpeedX = -ballSpeedX;
//            PlayerScore++;
//        }
        
        
    }
        
    public int AIMovement( int aiY, int ballY, double moveProb){
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


