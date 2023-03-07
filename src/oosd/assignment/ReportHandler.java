/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd.assignment;

import DataTypes.Fixture;
import DataTypes.Team;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class ReportHandler {
    //A seperate list of teams used to generate the reports
    private ArrayList<Team> Teams = new ArrayList<>();
    //String variables to represent each report to be viewed
    private String teamStatsReport = " ";
    private String teamRankingReport = " ";
    private String fixtureAndResultsChart = " ";

    public ReportHandler() {
    }
    //Function that is called to generate the fixture and result chart String defined above.
    //It's parameter is a fixtureList, and it adds the toString for each Fixture within the list to a string which is then saved as the fixtureAndResultChart String abovce
    public void generateFixtureAndResultChart(ObservableList<Fixture> FixtureList)
    {
        String string = "";
        for(Fixture eachFixture: FixtureList){
            string += eachFixture.toString() + "\n";
        }
        this.fixtureAndResultsChart = string;
    }
    //Function that is called to generate the team stats String defined above.
    //As each team has a getTeamStats function, this can be called for every team in the teamList and complied into one String. 
    //This String is then stored as the teamStatsReport above
    public void generateTeamStatsReport()
    {
       String teamStats = "";
       for(int i = 0; i < this.Teams.size(); i++){
           teamStats += this.Teams.get(i).getTeamStats() + "\n";
       }
       this.teamStatsReport = teamStats;
    }
    //Function that is called to generate the team ranking String defined above
    //This function is almost identical to the generateTeamStats function. The key difference is that the TeamList is sorted in order of sets won (as requested)
    //The string built from the sorted list is stored in the teamRankingReport String above.
     public void generateTeamRankingReport()
    {
        
        String teamRanking = "";

        Team temp;
        for (int i = 0; i < (this.Teams.size() - 1); i++)
        {
            for (int j = 0; j < (this.Teams.size() - i - 1); j++)
            {
                if (this.Teams.get(j).getSetsWon() < this.Teams.get(j + 1).getSetsWon())
                {
                    temp = this.Teams.get(j);
                    this.Teams.set(j, this.Teams.get(j + 1));
                    this.Teams.set(j+1,temp);
                    
                }
                
            }
        }
        
        for(int i = 0; i < this.Teams.size(); i++){
           teamRanking += this.Teams.get(i).getTeamStats() + "\n";
       }
        
        this.teamRankingReport = teamRanking;
        
    }
     
    //Clear function that wipes the TeamList
    public void clear()
    {
        this.Teams.clear();
    }
    
    //Function that takes in a team and adds it to the teamList
    public void addTeam(Team team)
    {   
        this.Teams.add(team);
    }
    
    
    //default setters and geters
    public ArrayList<Team> getTeams() {
        return Teams;
    }

    public void setStatistics(ArrayList<Team> Statistics) {
        this.Teams = Statistics;
    }

    public String getTeamStatsReport() {
        return teamStatsReport;
    }

    public void setTeamStatsReport(String teamStatsReport) {
        this.teamStatsReport = teamStatsReport;
    }

    public String getTeamRankingReport() {
        return this.teamRankingReport;
    }

    public void setTeamRankingReport(String teamRankingReport) {
        this.teamRankingReport = teamRankingReport;
    }

    public String getFixtureAndResultsChart() {
        return fixtureAndResultsChart;
    }

    public void setFixtureAndResultsChart(String fixtureAndResultsChart) {
        this.fixtureAndResultsChart = fixtureAndResultsChart;
    }
    
    
    
    @Override
    public String toString() {
        return "Report{" + "Teams=" + Teams + '}';
    }
    
    
}

