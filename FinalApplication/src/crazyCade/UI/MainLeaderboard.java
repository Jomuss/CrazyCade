/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.UI;

import crazyCade.ManagerLayer.LeaderBoardManager;
import crazyCade.modelLayer.PlayerModel;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class MainLeaderboard extends JPanel {
    private LeaderBoardManager manager;
    
    public MainLeaderboard(){
        super();
        manager = new LeaderBoardManager();
    }
    
    @Override
    public void paintComponent(Graphics g){
        int dy = 10;
        if(manager.overallLeaderboard.getLeaderboard().size() <= 8){
            for(PlayerModel p : manager.overallLeaderboard.getLeaderboard()){
                  g.drawString(p.getUserName() + "         " + p.getWinPct(), 0, dy);
                  dy += 25;
            }
        }
        else{
            for(int i = 0; i < 8; i++){
                g.drawString(manager.overallLeaderboard.getLeaderboard().get(i).getUserName() + "         " + manager.overallLeaderboard.getLeaderboard().get(i).getWinPct(), 0, dy);
                dy += 25;
            }
        }
    }
}
