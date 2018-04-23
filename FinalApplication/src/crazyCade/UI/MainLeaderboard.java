/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.UI;

import crazyCade.modelLayer.PlayerModel;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Alex
 */
public class MainLeaderboard extends JPanel {
   
    public MainLeaderboard(){
        super();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        int dy = 35;
        g.drawString("Player", 0, 10);
        g.drawString("Win pct.", 70, 10);
        g.drawLine(0, 15, 38, 15);
        g.drawLine(70, 15, 108, 15);
        if(MainWindow.manager.overallLeaderboard.getLeaderboard().size() <= 8){
            for(PlayerModel p : MainWindow.manager.overallLeaderboard.getLeaderboard()){
                if(p.getCurPlayerStatus())
                    g.setColor(Color.RED);
                else
                    g.setColor(Color.BLUE);
                g.drawString(p.getUserName(), 0, dy);
                g.drawString(String.valueOf(p.getOvrWinPct()), 80, dy);
                dy += 25;
            }
        }
        else{
            for(int i = 0; i < 8; i++){
                if(MainWindow.manager.overallLeaderboard.getLeaderboard().get(i).getCurPlayerStatus())
                    g.setColor(Color.RED);
                else 
                    g.setColor(Color.BLUE);
                g.drawString(MainWindow.manager.overallLeaderboard.getLeaderboard().get(i).getUserName(), 0, dy);
                g.drawString(String.valueOf(MainWindow.manager.overallLeaderboard.getLeaderboard().get(i).getOvrWinPct()), 80, dy);
                dy += 25;
            }
        }
    }
}
