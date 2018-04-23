/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.dataLayer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import crazyCade.modelLayer.PlayerModel;
/**
 *
 * @author Alex
 */
public class UserDao {
    public static ArrayList<String> userComponents;
    public static int userCount;
    
    public static void addUser(PlayerModel user, Boolean newUser) throws IOException{
        int i = 0;
        FileWriter fw = null;
        BufferedWriter bw = null;
        BufferedReader reader = null;
        File userFile = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao" + i + ".txt");
        if(!newUser){
            while(userFile.exists()){
                reader = new BufferedReader(new FileReader(userFile));
                if(user.getUserName().equals(reader.readLine())){
                    userFile = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + i + ".txt");
                    break;
                }
                else{
                    i++;
                    userFile = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + i + ".txt");
                }
            }
        }
        else{
            while(userFile.exists()){
                i++;
                userFile = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + i + ".txt");
            }
            userFile.createNewFile();
        }
        userCount = i;
        try {
            fw = new FileWriter(userFile);
            bw = new BufferedWriter(fw);
            bw.write(user.getUserName());
            bw.newLine();
            bw.write(user.getPassword());
            bw.newLine();
            bw.write(user.getEmail());
            bw.newLine();
            bw.write(String.valueOf(user.getPongWins()));
            bw.newLine();
            bw.write(String.valueOf(user.getPongLosses()));
            bw.newLine();
            bw.write(String.valueOf(user.getCheckersWins()));
            bw.newLine();
            bw.write(String.valueOf(user.getCheckersLosses()));
//            FileOutputStream fos;
//            fos = new FileOutputStream(file);
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }               
    }
    
    public static PlayerModel getUser(String username){
        userComponents = new ArrayList();
        PlayerModel user = null;
        BufferedReader reader = null;
        String line;
        int[] pongRecordArray = new int[2];
        int[] checkersRecordArray = new int[2];
        int i = 0;
        int j = 0;
        File file = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + j + ".txt");
        while(file.exists()){
            try{
                reader = new BufferedReader(new FileReader(file));
                if(reader.readLine().equals(username))
                    break;
                else {
                    j++; 
                    file = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + j + ".txt");
                }
            } catch(IOException e){
                e.printStackTrace();
            }
        }
        try {
            if(!file.exists())
                return null;
            else{ 
                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
                while(line != null){
//                    if(i > 1){
//                        if(i == 2){
//                            pongRecordArray[0] = Integer.valueOf(line.charAt(0));
//                            pongRecordArray[1] = Integer.valueOf(line.charAt(2));
//                        }
//                        else{
//                            checkersRecordArray[0] = Integer.valueOf(line.charAt(0));
//                            checkersRecordArray[1] = Integer.valueOf(line.charAt(2));
//                        }
//                    }
                    userComponents.add(line);
                    line = reader.readLine();
                    i++;
                }
                user = new PlayerModel(userComponents.get(0), userComponents.get(1), userComponents.get(2), Integer.valueOf(userComponents.get(3)), Integer.valueOf(userComponents.get(4)), Integer.valueOf(userComponents.get(5)), Integer.valueOf(userComponents.get(6)));
//                user.setUserName(userComponents.get(0));
//                user.setPassword(userComponents.get(1));
//                user.setPongRecord(pongRecordArray[0], pongRecordArray[1]);
//                user.setCheckersRecord(checkersRecordArray[0], checkersRecordArray[1]);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return user;
    }
    
    public static void calculateUserCount(){
        int j = 0;
        File file = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + j + ".txt");
        if(!file.exists()){
            userCount = 0;
        }
        else{
            while(file.exists()){
                j++;
                file = new File("C:/Users/Joe Moss/Desktop/CrazyCade/FinalApplication/src/gameDao/user" + j + ".txt");
            }
            userCount = j;
        }
    }
}
