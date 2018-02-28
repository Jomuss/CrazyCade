/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;

import java.util.ArrayList;

/**
 *
 * @author Joe Moss
 */
public class LeaderBoardModel {
    private ArrayList<PlayerModel> leaderBoard;
    
    public void populateLeaderboardFromPlayerData(){
        
    }
    public PlayerModel getPlayer(int place){
        PlayerModel player = new PlayerModel();
        player = leaderBoard.get(place--);
        return player;
    }
}
