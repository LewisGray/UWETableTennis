/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import DataTypes.ScoreSheet;
import DataTypes.Team;

/**
 *
 * @author DELL
 */
public class Fixture {
    //Team objects used to represent each team competing in the fixture
    private Team homeTeam;
    private Team awayTeam;
    //ScoreSheet object used to represent the match played as part of the fixture
    private ScoreSheet scoreSheet = null;

    public Fixture(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        
    }

    //default getters and setters
    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }
    public ScoreSheet getScoreSheet() {
        return scoreSheet;
    }

    public void setScoreSheet(ScoreSheet scoreSheet) {
        this.scoreSheet = scoreSheet;
    }
    
    
    @Override
    public String toString() {
        String finalScore = "";
        if(this.scoreSheet  == null)
        {
            finalScore = "N/A";
        }
        else
        {
            finalScore = Integer.toString(this.scoreSheet.getFinalScores()[0]) +":"+ Integer.toString(this.scoreSheet.getFinalScores()[1]);
        }
        String toString = (this.homeTeam + "(H)"+" vs "+"(A)" +this.awayTeam+"|| Final Score  = "+ finalScore);
        return toString;
    }
}
