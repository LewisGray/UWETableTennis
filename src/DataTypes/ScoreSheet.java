/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

/**
 *
 * @author DELL
 */
public class ScoreSheet {
    //Strings to represent the players competing 
    private String homePlayer1;
    private String homePlayer2;
    private String awayPlayer1;
    private String awayPlayer2;
    //A list of sets and a double set. These make up the match that the scoreSheet is representing 
    private Set[] SingleSets;
    private DoubleSet doubleSet;
    //Integer array holding the final score (HomeScore,AwayScore)
    private int[] finalScores = {0,0};
    
    public ScoreSheet(String g1,String g2,String g3,String g4,String g5,String g6,String g7,String g8,String g9,String g10,String g11,String g12,String g13,String g14,String g15,String hp1,String hp2,String ap1,String ap2)
    {
    String[] set1games = {g1, g2, g3};//Home 1 Away 1
    String[] set2games = {g4, g5, g6};// Home 2 Away 1
    String[] set3games = {g7, g8, g9};// Home 1 Away 2
    String[] set4games = {g10, g11, g12};// Home 2 Away 2
    String[] set5games = {g13, g14, g15};// Double

    Set set1 = new Set(hp1, ap1);
    Set set2 = new Set(hp2, ap1);
    Set set3 = new Set(hp1, ap2);
    Set set4 = new Set(hp2, ap2);
    DoubleSet doubleset = new DoubleSet(hp1, ap1, hp2, ap2);

    set1.setGames(set1games);
    set2.setGames(set2games);
    set3.setGames(set3games);
    set4.setGames(set4games);
    doubleset.setGames(set5games);

    Set[] scoreSheetSets = {set1, set2, set3, set4};
    
    
    this.homePlayer1=hp1;
    this.homePlayer2=hp2;
    this.awayPlayer1=ap1;
    this.awayPlayer2=ap2;
    this.SingleSets = scoreSheetSets;  
    this.doubleSet = doubleset;
    }

    //Function that adds up the winners of each set and adds both the home wins and the away wins into the final score array
    public void setFinalScores()
    {
        
        for(Set eachSet : this.SingleSets)
        {
            eachSet.setSetWinner();
            if (eachSet.getWinner().equals("Home"))
            {
                this.finalScores[0] +=1;
            }  
            if (eachSet.getWinner().equals("Away"))
            {
                this.finalScores[1] +=1;
            }  
        }
        this.doubleSet.setSetWinner();
        if(this.doubleSet.getWinner().equals("Home"))
        {
            this.finalScores[0] +=1;
        }  
        if(this.doubleSet.getWinner().equals("Away"))
        {
            this.finalScores[1] +=1;
        }  
        
    }
    
    //Default setters and getters
    public int[] getFinalScores() {
        return this.finalScores;
    }
   
    public String getHomePlayer1() {
        return this.homePlayer1;
    }

    public void setHomePlayer1(String homePlayer1) {
        this.homePlayer1 = homePlayer1;
    }

    public String getHomePlayer2() {
        return this.homePlayer2;
    }

    public void setHomePlayer2(String homePlayer2) {
        this.homePlayer2 = homePlayer2;
    }

    public String getAwayPlayer1() {
        return this.awayPlayer1;
    }

    public void setAwayPlayer1(String awayPlayer1) {
        this.awayPlayer1 = awayPlayer1;
    }

    public String getAwayPlayer2() {
        return this.awayPlayer2;
    }

    public void setAwayPlayer2(String awayPlayer2) {
        this.awayPlayer2 = awayPlayer2;
    }

    public Set[] getSingleSets() {
        return SingleSets;
    }

    public void setSingleSets(Set[] SingleSets) {
        this.SingleSets = SingleSets;
    }

    public DoubleSet getDoubleSet() {
        return this.doubleSet;
    }

    public void setDoubleSet(DoubleSet doubleSet) {
        this.doubleSet = doubleSet;
    }

    @Override
    public String toString() {
        return "\n Single Sets: \n" + this.SingleSets[0] + this.SingleSets[1] + this.SingleSets[2] + this.SingleSets[3] +"\n Double Set: \n" + this.doubleSet;
    }

   
    
    
    
    
    
}
