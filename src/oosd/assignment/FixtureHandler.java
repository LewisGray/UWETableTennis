/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd.assignment;

import DataTypes.Fixture;
import DataTypes.ScoreSheet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class FixtureHandler {
    //List of Fixtures
    private ObservableList<Fixture> fixtureList = FXCollections.observableArrayList();

    public FixtureHandler() {
    }

    //Function that takes in two team names and returns the fixture that those two teams compete in
    public Fixture findFixture(String homeTeam,String awayTeam)
    {
        for (int eachFixture = 0; eachFixture < this.fixtureList.size(); eachFixture++) {
            if (this.fixtureList.get(eachFixture).getHomeTeam().getTeamName().equals(homeTeam) & this.fixtureList.get(eachFixture).getAwayTeam().getTeamName().equals(awayTeam)) {
                return this.fixtureList.get(eachFixture);
            }
         }
        return null;
    }
    
    
    
    
    //default setter and getter
    public ObservableList<Fixture> getFixtureList() {
        return fixtureList;
    }

    public void setFixtureList(ObservableList<Fixture> fixtureList) {
        this.fixtureList = fixtureList;
    }

    @Override
    public String toString() {
        return "FixtureHandler{" + "fixtureList=" + fixtureList + '}';
    }
    
    
    
}
