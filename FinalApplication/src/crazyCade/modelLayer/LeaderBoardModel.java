/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;

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
    
    public void populateLeaderboardFromPlayerData(){
        ArrayList<String> userComponents = new ArrayList();
        File usersFolder = new File("C:/Users/Alex/Desktop/CrazyCade-origin (2)/CrazyCade-origin(real)/FinalApplication/src/crazyCade/gameDao");  
        PlayerModel p;
        String line;
        int i = 0;
        int j = 0;
        int size = 0;
        File[] folder = usersFolder.listFiles();
        for(File userFile : folder){
            try{
                BufferedReader reader = new BufferedReader(new FileReader(userFile));
                line = reader.readLine();
                while(line != null){
                    if(i > 1){
                        userComponents.add(String.valueOf(line.charAt(0)));    
                        userComponents.add(String.valueOf(line.charAt(4)));
                    }
                    else
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
            p = new PlayerModel(userComponents.get(0), userComponents.get(1), 
            Integer.valueOf(userComponents.get(2)), Integer.valueOf(userComponents.get(3)),
            Integer.valueOf(userComponents.get(4)), Integer.valueOf(userComponents.get(5)));
            leaderBoard.add(j, p);
            j++;
        }
        this.sortPlayers();
    }
    
    public PlayerModel getPlayer(int place){
        PlayerModel player = new PlayerModel();
        player = leaderBoard.get(place--);
        return player;
    }
    
    private void sortPlayers(){
        ArrayList<PlayerModel> temp = new ArrayList();
        int placer = leaderBoard.size();
        double bestScore = 0;
        for(int j = 0; j < leaderBoard.size(); j++){
            leaderBoard.get(j).setPosition(j);
        }
        for(int i = 0; i < leaderBoard.size(); i++){
            for(int k = 0; k < placer; k++){
                if(leaderBoard.get(i).getWinPct() > bestScore){
                    bestScore = leaderBoard.get(i).getWinPct();
                }
            }
            for(PlayerModel p : leaderBoard){
                if(p.getWinPct() == bestScore)
                    p.setPosition(i);               
            }
            bestScore = 0;
        }
        for(int l = 0; l < leaderBoard.size(); l++){
            for(PlayerModel p : leaderBoard){
                if(p.getPosition() == l)
                    temp.add(p);
            }
        }
        leaderBoard = new ArrayList();
        for(PlayerModel p : temp){
            leaderBoard.add(p);
        }
    }
    
    public ArrayList<PlayerModel> getLeaderboard(){
        return this.leaderBoard;
    }
    
    public void addToLeaderboard(PlayerModel p){
        this.leaderBoard.add(p);
    }
}
