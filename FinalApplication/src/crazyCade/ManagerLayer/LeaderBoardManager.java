/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.ManagerLayer;

import crazyCade.modelLayer.LeaderBoardModel;

/**
 *
 * @author Joe Moss
 */
public class LeaderBoardManager {
    private LeaderBoardModel overallLeaderboard;
    private LeaderBoardModel pongLeaderboard;
    private LeaderBoardModel checkersLeaderboard;
    
    public LeaderBoardManager(){
        
    }
    private void intitialize(){
        overallLeaderboard.populateLeaderboardFromPlayerData();
        pongLeaderboard.populateLeaderboardFromPlayerData();
        checkersLeaderboard.populateLeaderboardFromPlayerData();
    }
   
}
