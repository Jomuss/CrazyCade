/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.ManagerLayer;
import crazyCade.modelLayer.PlayerModel;
import java.util.ArrayList;

import java.util.*;  
import javax.mail.*;
import javax.mail.internet.*;  
import javax.activation.*;
/**
 *
 * @author Joe Moss
 */
public class PlayerManager {
    public ArrayList<PlayerModel> playerList;
    private static String to;
    private static final String from = "crazycadeservices@gmail.com";
    private static final String host = "smtp.gmail.com";
    
    public PlayerManager(){
        playerList = new ArrayList();    
    }
    
    public static void emailNewUser(PlayerModel player){
        Properties properties = System.getProperties();
        setupProperties(properties, player);
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("crazycadeservices@gmail.com", "Marco111");
            }
        });
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));  
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Welcome!");
            message.setText("Welcome to the CrazyCade network " + player.getUserName() + "!");
            Transport.send(message);
        } catch(MessagingException m){
            m.printStackTrace();
        }
    }
 
    public static void sendPlayerEmailForPositionChange(PlayerModel player, Boolean decrease, String leaderboardType){
        Properties properties = System.getProperties();
        setupProperties(properties, player);
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication("crazycadeservices@gmail.com", "Marco111");
            }
        }); 
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));  
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));  
            message.setSubject("Leaderboard position changed!");  
            if(decrease)
                message.setText("Hi, " + player.getUserName() + ", you recently moved up in the " + leaderboardType + " leaderboard! You are now in " + player.convertToPositionString() + " place!");
            else 
                message.setText("Hi, " + player.getUserName() + ", you recently moved down in the " + leaderboardType + " leaderboard :( You are now in " + player.convertToPositionString() + " place");
            Transport.send(message);
        } catch(MessagingException m){
            m.printStackTrace();
        }
    }
    
    private static void setupProperties(Properties properties, PlayerModel player){
        to = player.getEmail();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.host", host);  
        properties.put("mail.smtp.password", "password");
    }
}
