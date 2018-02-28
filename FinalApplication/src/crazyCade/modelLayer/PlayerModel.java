/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;

import crazyCade.dataLayer.userDAO;

/**
 *
 * @author Joe Moss
 */
public class PlayerModel implements userDAO {
    private String userName;
    private String password;  
    private int pongWins;
    private int[] pongRecord;
    private int checkersWins;
    private int[] checkersRecord;
    private int overallWins;
    
    PlayerModel(){
        pongRecord = new int[2];
        checkersRecord = new int[2];
    }

    /**
     * @return the userName
     */
    @Override
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pongWins
     */
    @Override
    public int getPongWins() {
        return pongWins;
    }

    /**
     * @param pongWins the pongWins to set
     */
    @Override
    public void setPongWins(int pongWins) {
        this.pongWins = pongWins;
    }

    /**
     * @return the pongRecord
     */
    @Override
    public String getPongRecord() {
        return pongRecord[0]+" - "+pongRecord[1];
    }

    /**
     * @param pongRecord the pongRecord to set
     */
    @Override
    public void setPongRecord(int[] pongRecord) {
        this.pongRecord = pongRecord;
    }

    /**
     * @return the checkersWins
     */
    @Override
    public int getCheckersWins() {
        return checkersWins;
    }

    /**
     * @param checkersWins the checkersWins to set
     */
    @Override
    public void setCheckersWins(int checkersWins) {
        this.checkersWins = checkersWins;
    }

    /**
     * @return the checkersRecord
     */
    @Override
    public String getCheckersRecord() {
        return checkersRecord[0]+" - "+checkersRecord[1];
    }

    /**
     * @param checkersRecord the checkersRecord to set
     */
    @Override
    public void setCheckersRecord(int[] checkersRecord) {
        this.checkersRecord = checkersRecord;
    }

    /**
     * @return the overallWins
     */
    @Override
    public int getOverallWins() {
        return overallWins;
    }

    /**
     * @param overallWins the overallWins to set
     */
    @Override
    public void setOverallWins(int overallWins) {
        this.overallWins = overallWins;
    }
    
}
