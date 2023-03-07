/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import DataTypes.Game;

/**
 *
 * @author DELL
 */
public class Set {
    //Strings to represent the players competing in the set
    private String homePlayer1;
    private String awayPlayer1;
    //Integer array that captures the home wins and away wins 
    private int[] teamWins ={0,0};//{Homewins,Awaywins}
    //Set of 3 games that make up a set
    private Game[] games = new Game[3];
    //String that shows the winner of the set. Either "Home" or "Away"
    private String winner = "N/A";
    
    public Set(String playerOne, String playerTwo)
    {
        this.games[0] = new Game();
        this.games[1] = new Game();
        this.games[2] = new Game();
        this.homePlayer1 = playerOne;
        this.awayPlayer1 = playerTwo;
    
    }
    
    //This function calculates the winner of the set by adding up the winner of each game within it.
    //The team with the most games won wins the set
    //The winner string is updated depending on the scores
    public void setSetWinner()
    {
        
        for(Game eachGame : this.games)
        {
            eachGame.setWinner();
            switch(eachGame.getWinner())
            {
                case "Home": 
                    this.teamWins[0] +=1;
                    break;
                    
                case "Away": 
                    this.teamWins[1] +=1;
                    break;
                    
                case "N/A": 
                    throw new java.lang.RuntimeException("Games have not been set");
            }
            }
        if (this.teamWins[0] > this.teamWins[1])
            {
                this.winner = "Home";
            }  
        else
            {
                this.winner = "Away";
            }
    }

    
   
    //This function takes in an array of strings, that each represent a score for a game in the set
    //The strings are decoded and scores set for each game
    public void setGames(String[] setScores )
    {
        for(int i = 0; i<setScores.length;i++){
            int []gameOneScores = getScoresFromString(setScores[i]);
            this.games[i].setHomeScore(gameOneScores[0]);
            this.games[i].setAwayScore(gameOneScores[1]);
        }
    
    }
    
    //This function is used when setting the game's scores.
    //It converts a string in the format (int:int) into an array of integers [homeScore,awayScore]
    public int[] getScoresFromString(String score)
    {
        String[] stringScores;
        int[] intScores = new int[2];
        stringScores = score.split(":");
        for(int i = 0; i<2 ;i++)
        {
        intScores[i] = Integer.valueOf(stringScores[i]);
        }
        return intScores;
        
    }
    
    //default setters and getters
    public String getHomePlayer() {
        return homePlayer1;
    }

    public void setHomePlayer(String homePlayer) {
        this.homePlayer1 = homePlayer;
    }

    public String getAwayPlayer() {
        return awayPlayer1;
    }

    public void setAwayPlayer(String awayPlayer) {
        this.awayPlayer1 = awayPlayer;
    }

    public Game[] getGames() {
        return games;
    }

    public void setGames(Game[] games) {
        this.games = games;
    }
    
    public String getWinner() {
        return winner;
    }

    @Override
    public String toString() {
        return "Set{"+homePlayer1+"vs"+awayPlayer1+"="+games[0].toString()+","+games[1].toString()+","+games[2].toString()+"} \n" ;
    }

   
    
    
    
}
