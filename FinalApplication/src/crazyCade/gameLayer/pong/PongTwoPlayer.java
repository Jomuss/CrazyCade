/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;



import processing.core.PApplet;
import java.util.Random;
import javax.swing.JOptionPane;




/**
 *
 * @author     Joe Moss
 Reference used for Processing/PongOnePlayer: http://drdoane.com/thinking-through-a-basic-pong-game-in-processing/
 */

public class PongTwoPlayer extends PApplet{
    boolean playingPong = true;
    PApplet inst = this;
    Random rand;
    PlayerOnePaddle playerOnePaddle;
    PlayerTwoPaddle playerTwoPaddle;
    Ball ball;
    static PongTwoPlayerSelector playerTwoSelector;
    PlayerScore PlayerScore;
    AIScore playerTwoScore;

//    private int ballX = 75, ballY = 75, ballDiameter = 30, ballRadius = 15;
//    private int ballSpeedX = (rand.nextInt(2)+2), ballSpeedY = (rand.nextInt(2)-4);
//    private int padHeight = 50, padWidth = 20, playerPadX, playerTwoPaddl = 50;
//    private int AIpadX = 5, AIpadY = 50, AICount = 0, AImaxCount = 15, AISpeed;
//    private double moveProb = .75;
    private int pentValue;
    int newY = 0;
    
    /**
     * @param args the command line arguments
     */
    public PongTwoPlayer(){
        rand = new Random();
        playerTwoPaddle = new PlayerTwoPaddle(this);
        ball = new Ball();
        PlayerScore = new PlayerScore();
        playerTwoScore = new AIScore();
        playerOnePaddle = new PlayerOnePaddle(this);

        
//        print(SerialHandler.list());
//        myPort = new SerialHandler(this, SerialHandler.list()[0], 9600);
          
    }

    public PongTwoPlayer(PongTwoPlayerSelector selector){
       PApplet.main("crazyCade.gameLayer.pong.PongTwoPlayer");
       playerTwoSelector = selector;
    }
    public void initialize(PongTwoPlayerSelector selector){

//        PApplet.main("crazyCade.gameLayer.pong.PongTwoPlayer");

    }
    private void endGame(){
        playerTwoSelector.gameOver();
        surface.setVisible(false);
    }
    private void playerOneWin(){
       JOptionPane.showMessageDialog(frame, "Congratulations Player One, You Win!");
       endGame();
    }
    private void playerTwoWin(){
       JOptionPane.showMessageDialog(frame, "Congratulations Player Two, You Win!");
       endGame();
    }
        
    public void settings(){
         size(500, 400);
    }

    public void setup(){
//        myPort = new SerialHandler();
    }
    public void draw(){
        background(200, 200, 200);
        if(playerTwoScore.score < 1 && PlayerScore.score < 1){
            playerOnePaddle.padY = playerOnePaddle.getMove();
            playerTwoPaddle.padY = playerTwoPaddle.getMove();

            fill(ball.red, ball.green, ball.blue);
            ellipse(ball.ballX, ball.ballY, ball.ballDiameter, ball.ballDiameter);

            fill(PongTwoPlayerSelector.red, PongTwoPlayerSelector.green, PongTwoPlayerSelector.blue);
            rect(playerOnePaddle.playerPadX, playerOnePaddle.padY, playerOnePaddle.padWidth, playerOnePaddle.padHeight);

            fill(PongTwoPlayerSelector.AIred, PongTwoPlayerSelector.AIgreen, PongTwoPlayerSelector.AIblue);
            rect(playerTwoPaddle.playerPadX, playerTwoPaddle.padY, playerTwoPaddle.padWidth, PongOnePlayerSelector.AIpadHeight);

            ball.ballMovement(playerOnePaddle, playerTwoPaddle, height, width, playerTwoScore, PlayerScore);
            textSize(32);
            fill(0,0,0);
            text(playerTwoScore.score, 75, 30, 0);
            text(PlayerScore.score, 400, 30, 0);
        }
        else if(playerTwoScore.score >= 1){
            textSize(35);
            fill(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            text("Sorry, You Lose!", 0, height*1/2);
            textSize(50);
            text("Thanks for Playing!", 0, height*2/3);
            playerOnePaddle.gameOver();
            playerTwoPaddle.gameOver();
            dispose();
            playerTwoWin();
            
            
        }
        else{
            textSize(35);
            fill(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            text("Congratulations, You Win!", 0, height*1/2);
            textSize(50);
            text("Thanks for Playing!", 0, height*2/3);
            playerOnePaddle.gameOver();
            playerTwoPaddle.gameOver();
            dispose();
            playerOneWin();
        }
        
        
    }
                //Based on code from https://processing.org/reference/keyCode.html
//    public void keyPressed(){
//        if(keyPressed){
//            if (key == 'w') {
//                if(playerTwoPaddle.padY < 10)
//                    playerTwoPaddle.padY = playerTwoPaddle.padY;
//                else
//                    playerTwoPaddle.padY = playerTwoPaddle.padY - 10;
//            }else if (key == 's') {
//                if(playerTwoPaddle.padY > height -60)
//                    playerTwoPaddle.padY = playerTwoPaddle.padY;
//                else
//                    playerTwoPaddle.padY = playerTwoPaddle.padY + 10;             
//            }else
//                playerTwoPaddle.padY = playerTwoPaddle.padY;
//            
//        }
//}
        
 
//        if(ballX > width){
//            ballX = (int) (width*.5);
//            ballSpeedX = -ballSpeedX;
//            playerTwoScore++;
//        }else if(ballX < 0){
//            ballX = (int) (width*.5);
//            ballSpeedX = -ballSpeedX;
//            PlayerScore++;
//        }
        
        
    
        
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


