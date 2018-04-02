/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.UI;

import crazyCade.ManagerLayer.LeaderBoardManager;
import crazyCade.modelLayer.PlayerModel;
import java.awt.Color;
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
        int dy = 35;
        g.drawString("Player", 0, 10);
        g.drawString("Win pct.", 70, 10);
        g.drawLine(0, 15, 38, 15);
        g.drawLine(70, 15, 108, 15);
        if(manager.overallLeaderboard.getLeaderboard().size() <= 8){
            for(PlayerModel p : manager.overallLeaderboard.getLeaderboard()){
                if(p.getCurPlayerStatus())
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.RED);
                g.drawString(p.getUserName(), 0, dy);
                g.drawString(String.valueOf(p.getCurWinPct()), 80, dy);
                dy += 25;
            }
        }
        else{
            for(int i = 0; i < 8; i++){
                g.drawString(manager.overallLeaderboard.getLeaderboard().get(i).getUserName(), 0, dy);
                g.drawString(String.valueOf(manager.overallLeaderboard.getLeaderboard().get(i).getCurWinPct()), 80, dy);
                dy += 25;
            }
        }
    }
    
    public LeaderBoardManager getManager(){
        return this.manager;
    }
}
