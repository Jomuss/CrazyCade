/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author Alex
 */
public class UserDao {
    public static ArrayList<String> userComponents;
    
    public static void addUser(PlayerModel user) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        File userFile = new File("C:/Users/Alex/Java/StartingWindows/src/gamedao/" + user.getUserName() + ".txt");
        userFile.createNewFile();        
        try {
            fw = new FileWriter(userFile);
            bw = new BufferedWriter(fw);
            bw.write(user.getUserName() + "\n");
            bw.write(user.getPassword() + "\n");
            bw.write(user.getPongRecord() + "\n");
            bw.write(user.getCheckersRecord());
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
    
    public static PlayerModel getUser(File file){
        userComponents = new ArrayList();
        PlayerModel user = null;
        BufferedReader reader = null;
        String line;
        int[] pongRecordArray = new int[2];
        int[] checkersRecordArray = new int[2];
        int i = 0;
        try {
            if(!file.exists())
                return null;
            else{ 
                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
                while(line != null){
                    if(i > 1){
                        if(i == 2){
                            pongRecordArray[0] = line.charAt(0);
                            pongRecordArray[1] = line.charAt(2);
                        }
                        else{
                            checkersRecordArray[0] = line.charAt(0);
                            checkersRecordArray[1] = line.charAt(2);
                        }
                    }
                    userComponents.add(line);
                    line = reader.readLine();
                    i++;
                }
                user = new PlayerModel();
                user.setUserName(userComponents.get(0));
                user.setPassword(userComponents.get(1));
                user.setPongRecord(pongRecordArray);
                user.setCheckersRecord(checkersRecordArray);
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return user;
    }
}
