/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Team {

    //String representing the Team name
    private String teamName;
    //ArrayList to hold the names of the players in the Team 
    private ArrayList<String> players = new ArrayList<String>();
    //Integers representing the Team's statistics
    private int matchesPlayed = 0;
    private int matchesWon = 0;
    private int setsWon = 0;

    //Function that simulates a match being played by the team by updating it's statistics.
    //The boolean value won determines whether or not the team won the game and the number of sets won is added 
    public void matchPlayed(boolean won, int setsWon) {
        if (won) {
            this.matchesWon++;
        }
        this.matchesPlayed++;
        this.setsWon += setsWon;

    }

    //Here is the constructor that allows an instance of the class to be created
    public Team(String TeamName) {
        this.teamName = TeamName;
    }

    //Funcion that takes in a player name and adds it to the Team's player list
    public void addPlayer(String PlayerName) {
        this.players.add(PlayerName);
    }

  
    
    //Returns the  Team's current statistics in string format
    public String getTeamStats() {
        String teamStats = "Team Name = " + this.teamName + " Matches Played = " + this.matchesPlayed + " Matches Won = " + this.matchesWon + " Sets Won = " + this.setsWon;

        return teamStats;

    }
    //This function decreases the team stats when the modify button has been pressed.
    public void modify(int SetsWon, boolean matchWon) {
        this.matchesPlayed = this.matchesPlayed - 1;
        this.setsWon = this.setsWon - SetsWon;
        if (matchWon) {
            this.matchesWon = this.matchesWon - 1;
        }
    }

    //Default setters and getters
    public ArrayList<String> getPlayerList() {
        return this.players;
    }
    public String getTeamName() {
        String name = this.teamName;
        return name;
    }
    
    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getMatchesWon() {
        return matchesWon;
    }

    public void setMatchesWon(int matchesWon) {
        this.matchesWon = matchesWon;
    }

    public int getSetsWon() {
        return setsWon;
    }

    public void setSetsWon(int setsWon) {
        this.setsWon = setsWon;
    }

    @Override
    public String toString() {
        return teamName;
    }

}
