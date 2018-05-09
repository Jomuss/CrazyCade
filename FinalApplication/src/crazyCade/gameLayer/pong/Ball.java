/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;
import java.util.Random;
/**
 *
 * @author Joe Moss
 */
public class Ball {
    Random rand = new Random();
    int ballX = 75, ballY = 75, ballDiameter = 30, ballRadius = 15;
    int ballSpeedX = (rand.nextInt(1)+4), ballSpeedY = (rand.nextInt(2)-4);
    int red = rand.nextInt(256), green = rand.nextInt(256), blue = rand.nextInt(256);
    
    void ballMovement(PlayerOnePaddle playerPaddle, AIPaddle AIpad, int height, int width, AIScore AIScore, PlayerScore PlayerScore){
        if(ballX > playerPaddle.playerPadX - 10 && ballX < playerPaddle.playerPadX + playerPaddle.padWidth){
            if(ballY >= playerPaddle.padY && ballY <= playerPaddle.padY + playerPaddle.padHeight){
                if(ballSpeedX > 0)
                    ballSpeedX = -ballSpeedX;
            }
        }
//        if(ballX + ballRadius > width)
//            ballSpeedX = -ballSpeedX;
        if(ballX-10 < AIpad.AIpadX + AIpad.padWidth && ballX > AIpad.AIpadX){
            if(ballY >= AIpad.AIpadY && ballY <= AIpad.AIpadY + PongOnePlayerSelector.AIpadHeight)
                if(ballSpeedX < 0)
                    ballSpeedX = -ballSpeedX;
        }
    

//        if(ballX < 15){
//            ballSpeedX = - ballSpeedX;
//        }

        if(ballY > height-15){
            ballSpeedY = -ballSpeedY;
        }
        if(ballY < 15){
            ballSpeedY = -ballSpeedY;
        }
        ballY = ballY + ballSpeedY;
        ballX = ballX + ballSpeedX;
        if(ballX > width){
            ballX = (int) (width*.5);
            ballSpeedX = -ballSpeedX;
            AIScore.score++;
        }else if(ballX < 0){
            ballX = (int) (width*.5);
            ballSpeedX = -ballSpeedX;
            PlayerScore.score++;
        }
    }
        void ballMovement(PlayerOnePaddle playerPaddle, PlayerTwoPaddle playerTwoPaddle, int height, int width, AIScore AIScore, PlayerScore PlayerScore){
        if(ballX > playerPaddle.playerPadX - 10 && ballX < playerPaddle.playerPadX + playerPaddle.padWidth){
            if(ballY >= playerPaddle.padY && ballY <= playerPaddle.padY + playerPaddle.padHeight){
                if(ballSpeedX > 0)
                    ballSpeedX = -ballSpeedX;
            }
        }
//        if(ballX + ballRadius > width)
//            ballSpeedX = -ballSpeedX;

        if(ballX-10 < playerTwoPaddle.playerPadX + playerTwoPaddle.padWidth && ballX > playerTwoPaddle.playerPadX){
            if(ballY >= playerTwoPaddle.padY && ballY <= playerTwoPaddle.padY + playerTwoPaddle.padHeight)
                if(ballSpeedX < 0)
                    ballSpeedX = -ballSpeedX;
        }
         if(ballY > height-15){
            ballSpeedY = -ballSpeedY;
        }
        if(ballY < 15){
            ballSpeedY = -ballSpeedY;
        }
        ballY = ballY + ballSpeedY;
        ballX = ballX + ballSpeedX;
        if(ballX > width){
            ballX = (int) (width*.5);
            ballSpeedX = -ballSpeedX;
            AIScore.score++;
        }else if(ballX < 0){
            ballX = (int) (width*.5);
            ballSpeedX = -ballSpeedX;
            PlayerScore.score++;
        }
    }
}