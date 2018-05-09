/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.pong;



import processing.core.PApplet;
import java.util.Random;
import javax.swing.JOptionPane;
import crazyCade.UI.MainWindow;
import java.io.*;
import javax.sound.sampled.*;





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
    AudioInputStream ais;
    String fileName;
    private int pentValue;
    int newY = 0;
    File hitSoundFile;
    Clip hitSound;
    
    /**
     * @param args the command line arguments
     */
    public PongTwoPlayer(){
        rand = new Random();
        playerTwoPaddle = new PlayerTwoPaddle(this);
        ball = new Ball(this);
        PlayerScore = new PlayerScore();
        playerTwoScore = new AIScore();
        playerOnePaddle = new PlayerOnePaddle(this);
        try{
            loadSounds();
        }catch(Exception e){
            
        }
        
        

        
//        print(SerialHandler.list());
//        myPort = new SerialHandler(this, SerialHandler.list()[0], 9600);
          
    }
    private void loadSounds()throws Exception{
        // Hit Sound found at https://freesound.org/people/LloydEvans09/sounds/321802/
        hitSoundFile = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/soundFIles/hit.wav");
        if(hitSoundFile.exists()){
                ais = AudioSystem.getAudioInputStream(hitSoundFile.toURI().toURL());
                hitSound = AudioSystem.getClip();
                hitSound.open(ais);
                hitSound.setFramePosition(0);
        }else{
            JOptionPane.showMessageDialog(frame, "Sounds could not be loaded");
        }
    }
    public void playHitSound(){
        hitSound.loop(0);
        hitSound.start();
        hitSound.setFramePosition(0);
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
        endGame();
       JOptionPane.showMessageDialog(frame, "Congratulations "+MainWindow.curUser.getUserName()+", You Win!");
       playerTwoSelector.mainGUI.winPong();
       
    }
    
    private void playerTwoWin(){
        endGame();
       JOptionPane.showMessageDialog(frame, "Congratulations Player Two, You Win!");
       playerTwoSelector.mainGUI.losePong();
       
    }
        
    public void settings(){
         size(500, 400);
    }

    public void setup(){
//        myPort = new SerialHandler();
    }
    public void draw(){
        background(200, 200, 200);
        if(playerTwoScore.score < 11 && PlayerScore.score < 11){
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
        else if(playerTwoScore.score > 11){
            textSize(35);
            fill(rand.nextInt(256),rand.nextInt(256),rand.nextInt(256));
            text("Player Two Wins!", 0, height*1/2);
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
            text("Player One Wins!", 0, height*1/2);
            textSize(50);
            text("Thanks for Playing!", 0, height*2/3);
            playerOnePaddle.gameOver();
            playerTwoPaddle.gameOver();
            dispose();
            playerOneWin();
        }
        
        
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


