/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crazyCade.modelLayer;



/**
 *
 * @author Joe Moss
 */
public class PlayerModel {
    private String userName;
    private String password;  
    private final String email;
    private int pongWins;
    private int pongLosses;
    private int checkersWins;
    private int checkersLosses;
    private int overallWins;
    private int position, tempPosition;
    private Boolean curPlayer = false;
    private double ovrWinPct;
    private double pongWinPct;
    private double checkersWinPct;
    private double curWinPct;
    
//    public PlayerModel(){
//
//    }
    
      public PlayerModel(String userName, String password, String email, int pongWins, int pongLosses, int checkersWins, int checkersLosses){
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.pongWins = pongWins;
        this.checkersWins = checkersWins;
        this.pongLosses = pongLosses;
        this.checkersLosses = checkersLosses;
        this.updatePlayer();
    }
      
    private Boolean checkGamesPlayed(int leaderboardType){
        if(this.calculateGamesPlayed(leaderboardType) == 0)
            return false;
        else 
            return true;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the pongWins
     */
    public int getPongWins() {
        return this.pongWins;
    }

    /**
     * @param pongWins the pongWins to set
     */
    public void addToPongWins() {
        this.pongWins++;
        this.updatePlayer();
    }

    /**
     * @return the pongRecord
     */
    public String getPongRecord() {
        return String.valueOf(pongWins)+" - "+ String.valueOf(pongLosses);
    }

    /**
     * @param pongRecord the pongRecord to set
     */
    public void setPongRecord(int wins, int losses) {
        this.pongWins = wins;
        this.pongLosses = losses;
    }

    /**
     * @return the checkersWins
     */
    public int getCheckersWins() {
        return this.checkersWins;
    }

    /**
     * @param checkersWins the checkersWins to set
     */
    public void addToCheckersWins() {
        this.checkersWins++;
        this.updatePlayer();
    }

    /**
     * @return the checkersRecord
     */
    public String getCheckersRecord() {
        return checkersWins+" - "+checkersLosses;
    }

    /**
     * @param checkersRecord the checkersRecord to set
     */
    public void setCheckersRecord(int wins, int losses) {
        this.checkersWins = wins;
        this.checkersLosses = losses;
    }

    /**
     * @return the overallWins
     */
    public int getOverallWins() {
        return this.overallWins;
    }

    /**
     * @param overallWins the overallWins to set
     */
    public void setOverallWins(int overallWins) {
        this.overallWins = overallWins;
    }
    
    private int calculateGamesPlayed(int leaderboardType){
        if(leaderboardType == 0)
            return pongWins + pongLosses + checkersWins + checkersLosses;
        else if(leaderboardType == 1)
            return pongWins + pongLosses;
        else
            return checkersWins + checkersLosses;
    }
    
    public int getTotalGamesPlayed(){
        return this.calculateGamesPlayed(0);
    }
    
    public int getPosition(){
        return this.position;
    }
    
    public void setPosition(int position){
        this.position = position;
    }
    
    public void declareCurPlayer(){
        this.curPlayer = true;
    }
    
    public Boolean getCurPlayerStatus(){
        return this.curPlayer;
    }
    
    public void playerLost(Boolean pong){
        if(pong)
            this.pongLosses++;
        else
            this.checkersLosses++;
        this.updatePlayer();
    }
    
    public int getPongLosses(){
        return this.pongLosses;
    }
    
    public int getCheckersLosses(){
        return this.checkersLosses;
    }
    
    public double getOvrWinPct(){
        return this.ovrWinPct;
    }
    
    public double getPongWinPct(){
        return this.pongWinPct;
    }
    
    public double getCheckersWinPct(){
        return this.checkersWinPct;
    }
    
    public void setCurWinPct(double winPct){
        this.curWinPct = winPct;
    }
    
    public double getCurWinPct(){
        return this.curWinPct;
    }
    
    private double roundCurWinPct(double curWinPct){
        curWinPct = Math.round(curWinPct * 100.0) / 100.0;
        return curWinPct;
    }
    
    private void updatePlayer(){
        this.overallWins = this.checkersWins + this.pongWins;
        try{
            if(this.checkGamesPlayed(0)){
                this.ovrWinPct = ((double)this.overallWins / (double)this.calculateGamesPlayed(0));
                this.ovrWinPct = this.roundCurWinPct(ovrWinPct);
            }
            else
                this.ovrWinPct = 0.0;
        } catch(ArithmeticException a){
            this.ovrWinPct = 0.0;
        }
        try{
            if(this.checkGamesPlayed(1)){
                this.pongWinPct = (double)this.pongWins / (double)this.calculateGamesPlayed(1);
                this.pongWinPct = this.roundCurWinPct(pongWinPct);
            }
            else 
                this.pongWinPct = 0.0;
        } catch(ArithmeticException a){
            this.pongWinPct = 0.0;
        }
        try{
            if(this.checkGamesPlayed(2)){
                this.checkersWinPct = (double)this.checkersWins / (double)this.calculateGamesPlayed(2);
                this.checkersWinPct = this.roundCurWinPct(checkersWinPct);
            }
            else 
                this.checkersWinPct = 0.0;
        } catch(ArithmeticException a){
            this.checkersWinPct = 0.0;
        }
    }

    public String getEmail() {
        return email;
    }
    
    public void setTempPosition(int tempPosition){
        this.tempPosition = tempPosition;
    }
    
    public int getTempPosition(){
        return this.tempPosition;
    }
    
    public String convertToPositionString(){
        int temp = this.getPosition() + 1;
        if(this.getLastInt(position) == 1)
            return String.valueOf(temp) + "st";
        else if(this.getLastInt(position) == 2)
            return String.valueOf(temp) + "nd";
        else if(this.getLastInt(position) == 3)
            return String.valueOf(temp) + "rd";
        else
            return String.valueOf(temp) + "th";
    }
    
    private int getLastInt(int position){
        String numString = Integer.toString(position);
        int[] nums = new int[numString.length()];
        for(int i = 0; i < numString.length(); i++){
            nums[i] = numString.charAt(i);
        }
        return nums[numString.length() - 1];
    }
}
