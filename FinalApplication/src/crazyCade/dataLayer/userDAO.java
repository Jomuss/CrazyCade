/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.dataLayer;

/**
 *
 * @author Joe Moss
 */
public interface userDAO {

    /**
     * @return the checkersRecord
     */
    String getCheckersRecord();

    /**
     * @return the checkersWins
     */
    int getCheckersWins();

    /**
     * @return the overallWins
     */
    int getOverallWins();

    /**
     * @return the password
     */
    String getPassword();

    /**
     * @return the pongRecord
     */
    String getPongRecord();

    /**
     * @return the pongWins
     */
    int getPongWins();

    /**
     * @return the userName
     */
    String getUserName();

    /**
     * @param checkersRecord the checkersRecord to set
     */
    void setCheckersRecord(int[] checkersRecord);

    /**
     * @param checkersWins the checkersWins to set
     */
    void setCheckersWins(int checkersWins);

    /**
     * @param overallWins the overallWins to set
     */
    void setOverallWins(int overallWins);

    /**
     * @param password the password to set
     */
    void setPassword(String password);

    /**
     * @param pongRecord the pongRecord to set
     */
    void setPongRecord(int[] pongRecord);

    /**
     * @param pongWins the pongWins to set
     */
    void setPongWins(int pongWins);

    /**
     * @param userName the userName to set
     */
    void setUserName(String userName);
    
}
