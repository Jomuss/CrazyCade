/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datalayer;

import java.io.IOException;
import java.io.Serializable;
/**
 *
 * @author Alex
 */
public class UserModel implements Serializable{
    public String userName, password;
    public int pongScore, checkerScore, overallScore;
    
    public UserModel(String userName, String password, int pongScore, int checkerScore, int overallScore) throws IOException{
        this.userName = userName;
        this.password = password;
        this.pongScore = pongScore;
        this.checkerScore = checkerScore;
        this.overallScore = overallScore;
    }
    
    public void releaseUser() throws IOException{
        UserDao.addUser(this);
    }
    
}
