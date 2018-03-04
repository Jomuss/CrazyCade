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
    
    public static void addUser(UserModel user) throws IOException{
        FileWriter fw = null;
        BufferedWriter bw = null;
        File userFile = new File("C:/Users/Alex/Java/StartingWindows/src/gamedao/" + user.userName + ".txt");
        userFile.createNewFile();        
        try {
            fw = new FileWriter(userFile);
            bw = new BufferedWriter(fw);
            bw.write(user.userName + "\n");
            bw.write(user.password + "\n");
            bw.write(String.valueOf(user.overallScore + "\n"));
            bw.write(String.valueOf(user.pongScore + "\n"));
            bw.write(String.valueOf(user.checkerScore));
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
    
    public static UserModel getUser(File file){
        userComponents = new ArrayList();
        UserModel user = null;
        BufferedReader reader = null;
        String line;
        try {
            if(!file.exists())
                return null;
            else{ 
                reader = new BufferedReader(new FileReader(file));
                line = reader.readLine();
                while(line != null){
                    userComponents.add(line);
                    line = reader.readLine();
                }
                user = new UserModel(userComponents.get(0), userComponents.get(1), Integer.valueOf(userComponents.get(2)), Integer.valueOf(userComponents.get(3)), Integer.valueOf(userComponents.get(4)));
            }
        } catch(IOException e){
            e.printStackTrace();
        }
        return user;
    }
}
