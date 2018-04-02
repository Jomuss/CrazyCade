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
    public LeaderBoardModel overallLeaderboard;
    public LeaderBoardModel pongLeaderboard;
    public LeaderBoardModel checkersLeaderboard;
    
    public LeaderBoardManager(){
        overallLeaderboard = new LeaderBoardModel();
        pongLeaderboard = new LeaderBoardModel();
        checkersLeaderboard = new LeaderBoardModel();
        this.intitialize();
    }
    
    private void intitialize(){
        overallLeaderboard.populateLeaderboardFromPlayerData(0);
        pongLeaderboard.populateLeaderboardFromPlayerData(1);
        checkersLeaderboard.populateLeaderboardFromPlayerData(2);
    }
   
}
