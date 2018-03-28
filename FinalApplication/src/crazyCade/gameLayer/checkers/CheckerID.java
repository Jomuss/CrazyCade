/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.gameLayer.checkers;

/**
 *
 * @author Joe Moss
 */
public class CheckerID {
    private char letter;
    private int num;

    /**
     * @return the letter
     */
    //A Field that stores the ID for a single Checker Square, Lettered A-H and Numbered 1-8
    public CheckerID(char letter, int num){
        this.letter = letter;
        this.num = num;
    }
    public char getLetter() {
        return letter;
    }

    /**
     * @param letter the letter to set
     */
    public void setLetter(char letter) {
        this.letter = letter;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(int num) {
        this.num = num;
    }
}
