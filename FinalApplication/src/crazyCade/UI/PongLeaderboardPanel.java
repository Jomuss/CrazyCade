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
public class PongLeaderboardPanel extends JPanel{
    
    @Override
    public void paintComponent(Graphics g){
        int dy = 50;
        g.drawString("Player", 30, 25);
        g.drawString("Record", 115, 25);
        g.drawString("Win pct.", 200, 25);
        g.drawLine(30, 30, 68, 30);
        g.drawLine(115, 30, 155, 30);
        g.drawLine(200, 30, 238, 30);
        if(MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard().size() <= 20){
            for(PlayerModel p : MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard()){
                if(p.getCurPlayerStatus())
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.RED);
                g.drawString(p.getUserName(), 30, dy);
                g.drawString(p.getCheckersRecord(), 120, dy);
                g.drawString(String.valueOf(p.getCurWinPct()), 210, dy);
                dy += 25;
            }
        }
        else{
            for(int i = 0; i < 20; i++){
                if(MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard().get(i).getCurPlayerStatus())
                    g.setColor(Color.BLUE);
                else
                    g.setColor(Color.RED);
                g.drawString(MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard().get(i).getUserName(), 10, dy);
                g.drawString(MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard().get(i).getCheckersRecord(), 30, dy);
                g.drawString(String.valueOf(MainWindow.leaderBoard.getManager().pongLeaderboard.getLeaderboard().get(i).getCurWinPct()), 50, dy);
                dy += 25;
            }
        }
    }
}
