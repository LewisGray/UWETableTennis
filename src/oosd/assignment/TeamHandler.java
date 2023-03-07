/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd.assignment;

import DataTypes.Team;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class TeamHandler {
    //List of Teams in the system
    private ObservableList<Team> teamList = FXCollections.observableArrayList();

    public TeamHandler() {
    }

    //default getter
    public ObservableList<Team> getTeamList() {
        return this.teamList;
    }

    //Function to add a Team to the TeamList
    public void addTeam(String teamName) {
        Team newTeam = new Team(teamName);
        this.teamList.add(newTeam);
    }
    
    //Function that returns true if the teamName is taken.
    //Otherwise returns false
    public boolean checkExistingTeam(String teamName){
    for (int i = 0; i < this.teamList.size(); i++) {
                if (this.teamList.get(i).getTeamName().equals(teamName)) {
                    return true;
                }
    }
    return false;
    }
    
    //Function that adds a player to a team
    public void addPlayerToTeam(Team team, String playerName)
    {
        team.addPlayer(playerName);
    }

    @Override
    public String toString() {
        return "TeamHandler{" + "teamList=" + this.teamList + '}';
    }
    
    
    
    
    
}
