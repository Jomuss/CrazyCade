/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// Project is under CrazyCade-Orgin(2) in Downloads
package crazyCade.UI;

import crazyCade.dataLayer.UserDao;
import crazyCade.gameLayer.checkers.Checkers;
import crazyCade.gameLayer.pong.PongTwoPlayerSelector;
import crazyCade.ManagerLayer.LeaderBoardManager;
import crazyCade.gameLayer.checkers.CheckerManager;
import crazyCade.modelLayer.PlayerModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Alex
 */
public class MainWindow extends javax.swing.JFrame {
    Boolean guest;
    static String username;
    Checkers newCheckersGame;
    PongTwoPlayerSelector p;
    static MainLeaderboard leaderBoard;
    CheckersLeaderboard checkerLeaderboard;
    PongLeaderboard pongLeaderboard;
    public static LeaderBoardManager manager;
    private int guestWins;
    public static PlayerModel curUser;
    private static PlayerModel secondPlayer;
    public static Boolean pongPlayed;
     
    /**
     * Creates new form MainWindow
     */
    public MainWindow(Boolean guest) {
        initComponents();
        this.getContentPane().setBackground(new Color(238, 255, 3));
        pongPlayBtn.setBackground(Color.BLUE);
        pongPlayBtn.setForeground(Color.WHITE);
        checkersPlayBtn.setBackground(Color.BLUE);
        checkersPlayBtn.setForeground(Color.WHITE);
        pongLeaderboardBtn.setBackground(Color.BLUE);
        pongLeaderboardBtn.setForeground(Color.WHITE);
        checkersLeaderboardBtn.setBackground(Color.BLUE);
        checkersLeaderboardBtn.setForeground(Color.WHITE);
        logoutBtn.setBackground(Color.BLUE);
        logoutBtn.setForeground(Color.WHITE);
        mainLeaderboard1.setBackground(new Color(0, 255, 43));
        manager = new LeaderBoardManager();
        leaderBoard = new MainLeaderboard();
        this.guest = guest;
        if(!guest)
            scoreLabel.setText(String.valueOf(MainWindow.curUser.getOverallWins()));
        else{
            this.guestWins = 0;
            scoreLabel.setText(String.valueOf(guestWins));
        }
        // Possibly a guest subclass for the guests score
    }
    
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.setColor(Color.GREEN);
        g.setFont(new Font("Serif", Font.ITALIC, 38));
        if(!guest)
            g.drawString(curUser.getUserName(), 250, 90);
        else 
            g.drawString("Guest", 250, 90);
        g.setColor(Color.blue);
        g.drawString("Pong", 90, 185);
        g.setColor(Color.red);
        g.drawString("Checkers", 65, 300);
        g.setFont(new Font("Serif", Font.BOLD, 25));
        g.setColor(Color.green);
        g.drawString("Overall Leaderboard", 390, 185);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        pongPlayBtn = new javax.swing.JButton();
        pongLeaderboardBtn = new javax.swing.JButton();
        checkersPlayBtn = new javax.swing.JButton();
        checkersLeaderboardBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        mainLeaderboard1 = new crazyCade.UI.MainLeaderboard();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Your overall wins: ");

        pongPlayBtn.setText("Play");
        pongPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pongPlayBtnActionPerformed(evt);
            }
        });

        pongLeaderboardBtn.setText("Leaderboard");
        pongLeaderboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pongLeaderboardBtnActionPerformed(evt);
            }
        });

        checkersPlayBtn.setText("Play");
        checkersPlayBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkersPlayBtnActionPerformed(evt);
            }
        });

        checkersLeaderboardBtn.setText("Leaderboard");
        checkersLeaderboardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkersLeaderboardBtnActionPerformed(evt);
            }
        });

        logoutBtn.setText("Log Out");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainLeaderboard1Layout = new javax.swing.GroupLayout(mainLeaderboard1);
        mainLeaderboard1.setLayout(mainLeaderboard1Layout);
        mainLeaderboard1Layout.setHorizontalGroup(
            mainLeaderboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 215, Short.MAX_VALUE)
        );
        mainLeaderboard1Layout.setVerticalGroup(
            mainLeaderboard1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(checkersPlayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(pongPlayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(pongLeaderboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(checkersLeaderboardBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(147, 147, 147)
                        .addComponent(mainLeaderboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutBtn)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pongPlayBtn)
                            .addComponent(pongLeaderboardBtn))
                        .addGap(95, 95, 95)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkersPlayBtn)
                            .addComponent(checkersLeaderboardBtn)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(mainLeaderboard1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkersPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkersPlayBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);        
        try{
            newCheckersGame = new CheckerManager();
            newCheckersGame.initialize();
        }catch(Exception e){
            throw new RuntimeException("Could not start Checkers");
        }
        
        

        pongPlayed = false;
        if(!guest){
            JOptionPane.showMessageDialog(this, "Have your opponent sign in on the next screen!");
            LoginWindow secondPlayerLogin = new LoginWindow();
            this.setVisible(false);
            secondPlayerLogin.setVisible(true);
        }
        else{
            this.setVisible(false);
            newCheckersGame = new CheckerManager();
            newCheckersGame.initialize();
        }
    }//GEN-LAST:event_checkersPlayBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        if(guest.equals(true))
            System.exit(0);
        else{
            try {
                UserDao.addUser(MainWindow.curUser, false);
                System.exit(0);
            } catch(IOException e){
                Logger.getLogger(SignUpWindow.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void pongPlayBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pongPlayBtnActionPerformed
        // TODO add your handling code here:

        this.setVisible(false);
        p = new PongTwoPlayerSelector();
        p.setVisible(true);

        pongPlayed = true;
        if(!guest){
            JOptionPane.showMessageDialog(this, "Have your opponent sign in on the next screen!");
            LoginWindow secondPlayerLogin = new LoginWindow(false, this);
            this.setVisible(false);
            secondPlayerLogin.setVisible(true);
        }
        else{
            this.setVisible(false);
            p = new PongTwoPlayerSelector();
            p.setVisible(true);
        }

    }//GEN-LAST:event_pongPlayBtnActionPerformed

    private void pongLeaderboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pongLeaderboardBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        pongLeaderboard = new PongLeaderboard(this);
        pongLeaderboard.setVisible(true);
        pongLeaderboard.repaintPanel();
    }//GEN-LAST:event_pongLeaderboardBtnActionPerformed

    private void checkersLeaderboardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkersLeaderboardBtnActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        checkerLeaderboard = new CheckersLeaderboard(this);
        checkerLeaderboard.setVisible(true);
        checkerLeaderboard.repaintPanel();
    }//GEN-LAST:event_checkersLeaderboardBtnActionPerformed
    


    public void winCheckers(){
        
    }

    private void winCheckers(PlayerModel winner){



    private void winCheckers(){
        winner.addToCheckersWins();
        this.leaderboardsUpdate("Checkers");
        this.setOverallWinsLabel();
    }
    


    loseCheckers(){
         parent of 8b79a83... new
        MainWindow.curUser.playerLost(false);
    }

    private void loseCheckers(PlayerModel loser){
        // TODO add your handling code here:
        loser.playerLost(false);

        this.leaderboardsUpdate("Checkers");
        this.setOverallWinsLabel();


    public void losePong(){

    }
    private void losePong(PlayerModel loser){

        //TODO add your handling code here:
        loser.playerLost(true);
        this.leaderboardsUpdate("Pong");
        this.setOverallWinsLabel();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow(false).setVisible(true);
            }
        });
    }
    
    public static String getCurUsername(){
        return username;
    }
    
    public static MainLeaderboard getLeaderboardObject(){
        return leaderBoard;
    }
    
    private void leaderboardsUpdate(String typeUpdate){
        manager.update(0, MainWindow.curUser);
        mainLeaderboard1.repaint();
        if(typeUpdate.equals("Pong")) 
            manager.update(2, MainWindow.curUser);
        else 
            manager.update(1, MainWindow.curUser);
    }
    
    private void setOverallWinsLabel(){
        if(guest.equals(true)){
            this.guestWins++;
            scoreLabel.setText(String.valueOf(guestWins));
        }
        else{
            scoreLabel.setText(String.valueOf(MainWindow.curUser.getOverallWins()));
        }
    }
    
    public static void setSecondPlayer(PlayerModel secondPlayer){
        MainWindow.secondPlayer = secondPlayer;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton checkersLeaderboardBtn;
    private javax.swing.JButton checkersPlayBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton logoutBtn;
    private crazyCade.UI.MainLeaderboard mainLeaderboard1;
    private javax.swing.JButton pongLeaderboardBtn;
    private javax.swing.JButton pongPlayBtn;
    private javax.swing.JLabel scoreLabel;
    // End of variables declaration//GEN-END:variables
}
