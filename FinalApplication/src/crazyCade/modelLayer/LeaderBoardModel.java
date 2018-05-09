/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;

import crazyCade.ManagerLayer.PlayerManager;
import crazyCade.UI.MainWindow;
import crazyCade.dataLayer.UserDao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;  

/**
 *
 * @author Joe Moss
 */
public class LeaderBoardModel {
    private ArrayList<PlayerModel> leaderBoard;
    
    public LeaderBoardModel(){
        leaderBoard = new ArrayList();
    }
    
    public final void populateLeaderboardFromPlayerData(int leaderboardType){
        ArrayList<String> userComponents = new ArrayList();  
        PlayerModel player;
        String line;
        int i = 0;
        int j = 0;
        int size = 0;
        for(int k = 0; k < UserDao.userCount; k++){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + k + ".txt")));
                line = reader.readLine();
                while(line != null){
                    userComponents.add(line);
                    line = reader.readLine();
                    i++;
                }
                i = 0;
            } catch(FileNotFoundException f){
                System.out.print("File not found");
            } catch(IOException e){
                System.out.print("IO Exception caught");
            }
            player = new PlayerModel(userComponents.get(0), userComponents.get(1), userComponents.get(2),
            Integer.valueOf(userComponents.get(3)), Integer.valueOf(userComponents.get(4)),
            Integer.valueOf(userComponents.get(5)), Integer.valueOf(userComponents.get(6)));
            if(userComponents.get(0).equals(MainWindow.getCurUsername()))
                player.declareCurPlayer();
            leaderBoard.add(j, player);
            j++;
            userComponents = new ArrayList();
        }
        this.sortPlayers(leaderboardType, false);
    }
    
    public void updateLeaderboard(int leaderBoardType, PlayerModel curPlayer){
        for(int i = 0; i < leaderBoard.size(); i++){
            if(curPlayer.getUserName().equals(leaderBoard.get(i).getUserName())){
                leaderBoard.remove(i);
                leaderBoard.add(i, curPlayer);
            }
        }
        this.sortPlayers(leaderBoardType, true);
    }
    
//    public PlayerModel getPlayer(int place){
//        PlayerModel player = new PlayerModel();
//        player = leaderBoard.get(place--);
//        return player;
//    }
    
    private void sortPlayers(int leaderboardType, Boolean firstSort){
        int x = 0;
        int y = 0;
        ArrayList<PlayerModel> temp = new ArrayList();
        int placer = leaderBoard.size();
        double bestScore = 0.0;
        for(int j = 0; j < leaderBoard.size(); j++){
            if(leaderboardType == 0)
                leaderBoard.get(j).setCurWinPct(leaderBoard.get(j).getOvrWinPct());
            else if(leaderboardType == 1)
                leaderBoard.get(j).setCurWinPct(leaderBoard.get(j).getPongWinPct());
            else
                leaderBoard.get(j).setCurWinPct(leaderBoard.get(j).getCheckersWinPct());
            leaderBoard.get(j).setTempPosition(j);
        }
        for(int i = 0; i < placer; i++){
            for(int k = 0; k < leaderBoard.size(); k++){
                if(leaderBoard.get(k).getCurWinPct() > bestScore){
                    bestScore = leaderBoard.get(k).getCurWinPct();
                }               
            }
            if(bestScore == 0.0){
                for(int n = 0; n < leaderBoard.size(); n++){
                    temp.add(leaderBoard.get(n));
                }
                break;
            }
            else{
                for(int m = 0; m < leaderBoard.size(); m++){
                    if(leaderBoard.get(m).getCurWinPct() == bestScore){
                        temp.add(leaderBoard.get(m));
                        leaderBoard.remove(leaderBoard.get(m));
                    }
                }
            }
            bestScore = 0.0;
        }
        
        leaderBoard = new ArrayList();
        leaderBoard.addAll(temp);
        
        for(int i = 0; i < leaderBoard.size(); i++){
            leaderBoard.get(i).setPosition(i);
            if(firstSort)
                this.checkPlayerPositionChanged(leaderBoard.get(i), leaderboardType);
        }
    }
    
    public ArrayList<PlayerModel> getLeaderboard(){
        return this.leaderBoard;
    }
    
    public void addToLeaderboard(PlayerModel p){
        this.leaderBoard.add(p);
    }
    
    private void checkPlayerPositionChanged(PlayerModel changingPlayer, int leaderBoardType){
        String stringType; 
        if(leaderBoardType == 0)
            stringType = "Overall";
        else if(leaderBoardType == 1)
            stringType = "Pong";
        else
            stringType = "Checkers";
        if(changingPlayer.getTempPosition() != changingPlayer.getPosition()){
            if(changingPlayer.getPosition() > changingPlayer.getTempPosition())
                PlayerManager.sendPlayerEmailForPositionChange(changingPlayer, false, stringType);           
            else
                PlayerManager.sendPlayerEmailForPositionChange(changingPlayer, true, stringType);
        }
    }
}
