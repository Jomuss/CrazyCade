/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;



/**
 *
 * @author Joe Moss
 */
public class PlayerModel {
    private String userName;
    private String password;  
    private int pongWins;
    private int[] pongRecord;
    private int checkersWins;
    private int[] checkersRecord;
    private int overallWins;
    private int position;
    
    public PlayerModel(){
        this.setArrays();
    }
    
    public PlayerModel(String userName, String password, int pongWins, int pongLosses, int checkersWins, int checkersLosses){
        this.setArrays();
        this.userName = userName;
        this.password = password;
        this.pongRecord[0] = pongWins;
        this.checkersRecord[0] = checkersWins;
        this.pongRecord[1] = pongLosses;
        this.checkersRecord[1] = checkersLosses;
        this.pongWins = this.pongRecord[0];
        this.checkersWins = this.checkersRecord[0];
        this.overallWins = this.checkersWins + this.pongWins;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pongWins
     */
    public int getPongWins() {
        return this.pongRecord[0];
    }

    /**
     * @param pongWins the pongWins to set
     */
    public void setPongWins(int pongWins) {
        this.pongWins = pongWins;
    }

    /**
     * @return the pongRecord
     */
    public String getPongRecord() {
        return pongRecord[0]+" - "+pongRecord[1];
    }

    /**
     * @param pongRecord the pongRecord to set
     */
    public void setPongRecord(int[] pongRecord) {
        this.pongRecord = pongRecord;
    }

    /**
     * @return the checkersWins
     */
    public int getCheckersWins() {
        return this.checkersRecord[0];
    }

    /**
     * @param checkersWins the checkersWins to set
     */
    public void setCheckersWins(int checkersWins) {
        this.checkersWins = checkersWins;
    }

    /**
     * @return the checkersRecord
     */
    public String getCheckersRecord() {
        return checkersRecord[0]+" - "+checkersRecord[1];
    }

    /**
     * @param checkersRecord the checkersRecord to set
     */
    public void setCheckersRecord(int[] checkersRecord) {
        this.checkersRecord = checkersRecord;
    }

    /**
     * @return the overallWins
     */
    public int getOverallWins() {
        return this.pongRecord[0] + this.checkersRecord[0];
    }

    /**
     * @param overallWins the overallWins to set
     */
    public void setOverallWins(int overallWins) {
        this.overallWins = overallWins;
    }
    
    public double getWinPct(){
        double a;
        int gamesPlayed = pongRecord[0] + pongRecord[1] + checkersRecord[0] + checkersRecord[1];
        if(overallWins == 0)
            a = 0;
        else
            a = gamesPlayed / overallWins;
        return a;
    }
    
    public int getPosition(){
        return this.position;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    private void setArrays(){
        pongRecord = new int[2];
        checkersRecord = new int[2];
    }
}
