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
public class Game {
    //Integer variable to reflect the home and away score for the game
    private int homeScore;
    private int awayScore;
    //String variable to hold either "Home" or "Away" to depict the winner of the game
    private String winner;
    
    //When a game is constructed, the scores are initialised to 0
    public Game()
    {
        this.homeScore = 0;
        this.awayScore = 0;
        this.winner = "N/A";
    }

    //default setters and getters
    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getWinner() {
        return winner;
    }
    //Function that compares the home score to the away scores and sets the game's winner to either "Home" or "Away"
    public void setWinner() {
        if(this.homeScore > this.awayScore)
        {
            this.winner = "Home";
        }
        else
        {
            this.winner = "Away";  
        }
    }

    @Override
    public String toString() {
        return + homeScore + ":" + awayScore ;
    }
    
    
    
    
    
}
