/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.ManagerLayer;
import crazyCade.modelLayer.PlayerModel;
import java.util.ArrayList;
/**
 *
 * @author Joe Moss
 */
public class PlayerManager {
    public ArrayList<PlayerModel> playerList;
    
    
    public PlayerManager(){
        playerList = new ArrayList();
        
    }
    
    private void populateArrayFromFile(){
        
    }
    
}
