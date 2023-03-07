/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oosd.assignment;

import DataTypes.DoubleSet;
import DataTypes.Fixture;
import DataTypes.ScoreSheet;
import DataTypes.Set;
import DataTypes.Team;
import java.net.URL;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author DELL
 */
public class FXMLDocumentController implements Initializable {

    //These items are on the Admin Tab
    @FXML
    private VBox adminFunctions;
    @FXML
    private Button lockButton;
    @FXML
    private Button submitPasswordButton;
    @FXML
    private TextField passwordField;
    @FXML
    private Label securityLabel;
    @FXML
    private TextField teamNameEntry;
    @FXML
    private Button submitTeamName;
    @FXML
    private Label TeamLabel;
    @FXML
    private ComboBox<Team>selectPlayerTeam;
    @FXML
    private TextField playerNameEntry;
    @FXML
    private Button submitplayerName;
    @FXML
    private Label PlayerLabel;
    @FXML
    private Button generateFixtures;
    @FXML
    private Button generateTeamStatistics;
    //These items are on the Viewer Page Tab
    @FXML
    private ComboBox selectReport;
    @FXML
    private Button viewReport;
    @FXML
    private TextArea reportTextArea;
    @FXML
    private ComboBox<Fixture> selectFixture;
    //These items are on the Scoresheet Tab
    @FXML
    private ComboBox<Team> homeTeam;
    @FXML
    private ComboBox<Team> awayTeam;
    @FXML
    private ComboBox<String> homePlayer1;
    @FXML
    private ComboBox<String> homePlayer2;
    @FXML
    private ComboBox<String> awayPlayer1;
    @FXML
    private ComboBox<String> awayPlayer2;

    @FXML
    private TextField game1;
    @FXML
    private TextField game2;
    @FXML
    private TextField game3;
    @FXML
    private TextField game4;
    @FXML
    private TextField game5;
    @FXML
    private TextField game6;
    @FXML
    private TextField game7;
    @FXML
    private TextField game8;
    @FXML
    private TextField game9;
    @FXML
    private TextField game10;
    @FXML
    private TextField game11;
    @FXML
    private TextField game12;
    @FXML
    private TextField game13;
    @FXML
    private TextField game14;
    @FXML
    private TextField game15;
    @FXML
    private TextField finalScore;

    @FXML
    private Button createScoreSheet;
    @FXML
    private Button modifyScoreSheet;
    @FXML
    private Button submitScoreSheet;

    @FXML
    private Label scoreSheetTitleLabel;
    @FXML
    private Label selectATeamLabel;
    @FXML
    private Label enterScoresLabel;
    @FXML
    private Label guideText;
    @FXML
    private Label singleSetLabel;
    @FXML
    private Label doubleSetLabel;

    @FXML
    private GridPane scoreSheetGridPane;

    //Object to handle Teams
    private TeamHandler teamHandler = new TeamHandler();
    //Object to handle Fixtures
    private FixtureHandler fixtureHandler = new FixtureHandler();
    //Object to handle Reports
    private ReportHandler reportHandler = new ReportHandler();

    //////////////////////////////////////////
    //These functions are for the Admin Page//
    //////////////////////////////////////////
    
    
    
    
    
    
    //This function acts as a security barrier for the admin page
    //When the submit button is pressed, this function is called to check the password entered (admin)
    //If correct, the admin page is unlocked for use
    //Else an error message is displayed
    public void submitPasswordButtonPressed()
    {
    String password = passwordField.getText();
    passwordField.clear();
    if(password.equals("admin")){
        unlockAdminPage();
    }
    else{
        securityLabel.setText("Wrong password!");
    }
    }
    
    //Function that unlocks the Admin Page for use
    public void unlockAdminPage()
    {
        adminFunctions.setDisable(false);
        lockButton.setVisible(true);
        passwordField.setVisible(false);
        submitPasswordButton.setVisible(false);
        securityLabel.setText("Lock the page ->");
    }
    //Function that is called when the lock admin page button is pressed.
    //The function locks the admin page so it cannot be used unless unlocked. 
    public void lockAdminPage()
    {
        adminFunctions.setDisable(true);
        lockButton.setVisible(false);
        passwordField.setVisible(true);
        submitPasswordButton.setVisible(true);
        securityLabel.setText("Enter password:");
    }
    
    
    //Function that is called when the user clicks the submit button to add a new team into the TeamList.
    // It checks if the user has input a team name to be submitted, then checks to see that team name is taken. 
    // If all is good, a new Team object is created with the team name entered and is stored in the system.
    //A success or fail message is displayed depending on the user input and the textField is cleared for quality of life.
    public void submitTeamButtonPushed() {
        String teamName = teamNameEntry.getText();

        if (teamName.isEmpty()) {
            TeamLabel.setTextFill(Color.RED);
            TeamLabel.setText("Invalid Team Name");
        } else {
            if(teamHandler.checkExistingTeam(teamName)){
                    TeamLabel.setTextFill(Color.RED);
                    TeamLabel.setText("Team already exists!");
                    return;
                }
     
            }
            teamHandler.addTeam(teamName);
            TeamLabel.setTextFill(Color.GREEN);
            TeamLabel.setText("Success!");
            teamNameEntry.clear();

        }
    

    //Function that is called when the user clicks the submit button to add a player.
    //After checking if the user has entered a team to add the player to, and that a player name has been entered, the function locates the selected team.
    //Then it adds the player name to the Team's player list and displays a success (or error if invalid input) message. The TextField is cleared on success. 
    public void submitPlayerButtonPushed() {
        if (selectPlayerTeam.getValue() == null) {
            PlayerLabel.setTextFill(Color.RED);
            PlayerLabel.setText("No team selected!");
        } else {
            Team Team = selectPlayerTeam.getValue();
            String PlayerName = playerNameEntry.getText();
            playerNameEntry.clear();
            teamHandler.addPlayerToTeam(Team, PlayerName);
            PlayerLabel.setTextFill(Color.GREEN);
            PlayerLabel.setText("Success!");
            }

        }
    

    //Function that is called when the user presses the generate fixture button.
    //All previous fixture data is wiped, and the fixture array is populated with 2 fixtures between each team (Home and Away) 
    public void generateFixturesButtonPressed() {
        fixtureHandler.getFixtureList().clear();
        for (int i = 0; i < teamHandler.getTeamList().size(); i++) {
            for (int j = 0; j < teamHandler.getTeamList().size(); j++) {
                if (i == j) {
                    continue;
                } else {
                    Fixture newFixture = new Fixture(teamHandler.getTeamList().get(i), teamHandler.getTeamList().get(j));
                    fixtureHandler.getFixtureList().add(newFixture);
                }
            }
        }
        
        //THIS IS THE TEST DATA 
        //                                                h1 a1            h2a1              h1a2                   h2a2
        //                                       |       SET1       ||       SET2       ||       SET3        ||      SET4        ||       Double       |  h1     h2       a1   a2
        ScoreSheet filtonvsuwe = new ScoreSheet("11:2","3:11","11:5","11:9","11:1","11:1","1:11","5:11","11:6","11:2","3:11","11:5","0:11","1:11","2:11","alex","brian","jin","julia");
        ScoreSheet  uwevspage  = new ScoreSheet("11:2","3:11","11:5","11:9","11:1","11:1","1:11","5:11","11:6","11:2","3:11","11:5","0:11","1:11","2:11","jin","julia","peter","phil");
        filtonvsuwe.setFinalScores();
        uwevspage.setFinalScores();
        Fixture fixture1 = fixtureHandler.findFixture("filton","uwe");
        Fixture fixture2 = fixtureHandler.findFixture("uwe","page");
        updateTeamStatsAndSetScoreSheet(filtonvsuwe,fixture1);
        updateTeamStatsAndSetScoreSheet(uwevspage,fixture2);
        
    }

    //Function that is called when the generate team stats button is pressed.
    //A copy of each team is passed into the ReportHandler class object, and it's functions are run to generate the reports shown in the viwer page
    public void generateTeamStatsButtonPressed() {
        reportHandler.clear();

        for (int i = 0; i < teamHandler.getTeamList().size(); i++) {
            reportHandler.addTeam(teamHandler.getTeamList().get(i));

        }
        reportHandler.generateTeamStatsReport();
        reportHandler.generateFixtureAndResultChart(fixtureHandler.getFixtureList());
        reportHandler.generateTeamRankingReport();

    }

    ///////////////////////////////////////////////
    //These functions are for the Scoresheet Page//
    ///////////////////////////////////////////////    
    
    
    //Function that enables the scoresheet and populates the player comboBoxes with names from the correct team
    public void showScoreSheet(Fixture thisFixture)
    {
    selectATeamLabel.setText("");
    guideText.setText("");
    scoreSheetGridPane.setDisable(false);
    submitScoreSheet.setDisable(false);

    homePlayer1.getItems().clear();
    homePlayer2.getItems().clear();
    homePlayer1.getItems().addAll(thisFixture.getHomeTeam().getPlayerList());
    homePlayer2.getItems().addAll(thisFixture.getHomeTeam().getPlayerList());

    awayPlayer1.getItems().clear();
    awayPlayer2.getItems().clear();
    awayPlayer1.getItems().addAll(thisFixture.getAwayTeam().getPlayerList());
    awayPlayer2.getItems().addAll(thisFixture.getAwayTeam().getPlayerList());
}
    
    
    //Function that is called when the user presses the "create a new sheet" button on the scoreSheet tab
    //First, the program will search the list of fixtures until it finds the fixture with the correct home and away team (as entered by the user).
    //Once found (else an error message is displayed), the progam will enable the score sheet, fill the comboxes with players from each team and prompt the user to enter the match scores.
    public void createScoreSheetButtonPressed() {
        if (validateTeams()) {
            Fixture thisFixture = fixtureHandler.findFixture(homeTeam.getValue().getTeamName(),awayTeam.getValue().getTeamName());
            if(thisFixture == null)
            {
            disableScoreSheet();
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("Selected teams do not have a fixture");
            }
            else{
            if (thisFixture.getScoreSheet() == null) {
                enterScoresLabel.setTextFill(Color.BLACK);
                enterScoresLabel.setText("Please select the players and enter the match score below:");
                showScoreSheet(thisFixture);
                return;
            } else {
                disableScoreSheet();
                selectATeamLabel.setTextFill(Color.RED);
                selectATeamLabel.setText("Game already played please modify instead");
                return;
            }

        }   

    }
    }
    //Function called when the user presses the modify scoresheet button. It starts off by searching the fixtureList for the fixture with the correct home and away team(as entered by the user)).
    //Then, as we are modifying a scoreSheet, the team stats that were added to each team from the previous version of the scoreSheet are removed. 
    //This "removes" the match from existence (As though it was never entered) so that the submit scoresheet button can have the main functionality of storing the entered scoreSheet and adding Team Stats.
    //After the Team stats are altered, the previous scoresheet is displayed (ready to edit and submit). A prompt will appear so the user knows to edit the sheet.
    public void ModifyScoreSheetButtonPressed() {
        if (validateTeams()) {
            Fixture thisFixture = fixtureHandler.findFixture(homeTeam.getValue().getTeamName(),awayTeam.getValue().getTeamName());
            if(thisFixture == null)
            {
            disableScoreSheet();
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("Selected teams do not have a fixture");
            }
            else{
                    if (thisFixture.getScoreSheet() != null) {
                        ScoreSheet currentSheet = thisFixture.getScoreSheet();
                        if (currentSheet.getFinalScores()[0] > currentSheet.getFinalScores()[1]) {
                            thisFixture.getHomeTeam().modify(currentSheet.getFinalScores()[0], true);
                            thisFixture.getAwayTeam().modify(currentSheet.getFinalScores()[1], false);
                        } else {
                            thisFixture.getHomeTeam().modify(currentSheet.getFinalScores()[0], false);
                            thisFixture.getAwayTeam().modify(currentSheet.getFinalScores()[1], true);
                        }
                        showScoreSheet(thisFixture);
                        enterScoresLabel.setTextFill(Color.BLACK);
                        enterScoresLabel.setText("Please edit the match details below:");

                        //Setting the scores from the previous scoresheet
                        game1.setText(currentSheet.getSingleSets()[0].getGames()[0].toString());
                        game2.setText(currentSheet.getSingleSets()[0].getGames()[1].toString());
                        game3.setText(currentSheet.getSingleSets()[0].getGames()[2].toString());
                        game4.setText(currentSheet.getSingleSets()[1].getGames()[0].toString());
                        game5.setText(currentSheet.getSingleSets()[1].getGames()[1].toString());
                        game6.setText(currentSheet.getSingleSets()[1].getGames()[2].toString());
                        game7.setText(currentSheet.getSingleSets()[2].getGames()[0].toString());
                        game8.setText(currentSheet.getSingleSets()[2].getGames()[1].toString());
                        game9.setText(currentSheet.getSingleSets()[2].getGames()[2].toString());
                        game10.setText(currentSheet.getSingleSets()[3].getGames()[0].toString());
                        game11.setText(currentSheet.getSingleSets()[3].getGames()[1].toString());
                        game12.setText(currentSheet.getSingleSets()[3].getGames()[2].toString());
                        game13.setText(currentSheet.getDoubleSet().getGames()[0].toString());
                        game14.setText(currentSheet.getDoubleSet().getGames()[1].toString());
                        game15.setText(currentSheet.getDoubleSet().getGames()[2].toString());

                        //Setting the players from the previous score sheet
                        homePlayer1.setValue(currentSheet.getHomePlayer1());
                        homePlayer2.setValue(currentSheet.getHomePlayer2());
                        awayPlayer1.setValue(currentSheet.getAwayPlayer1());
                        awayPlayer2.setValue(currentSheet.getAwayPlayer2());
                        createScoreSheet.setDisable(true);
                        homeTeam.setDisable(true);
                        awayTeam.setDisable(true);
                        modifyScoreSheet.setDisable(true);
                        return;
                    } else {
                        disableScoreSheet();
                        selectATeamLabel.setTextFill(Color.RED);
                        selectATeamLabel.setText("Game is yet to be played; please create the score sheet");
                        return;
                    }

                }

            }
            
        }

    

    
   

    //This function is usually called when an error has occured with team entry on the scoreSheet, but is also called when a successful scoreSheet submisson has occured
    //It's purpose is to wipe the page and revert it to it's orignial state.
    //This helps to ensure that correct input is recieved (For example,the user cannot press "Submit a scoreSheet" with no teams entered)
    public void disableScoreSheet() {
        game1.clear();
        game2.clear();
        game3.clear();
        game4.clear();
        game5.clear();
        game6.clear();
        game7.clear();
        game8.clear();
        game9.clear();
        game10.clear();
        game11.clear();
        game12.clear();
        game13.clear();
        game14.clear();
        game15.clear();
        finalScore.setText("Final Team Scores");
        game1.setStyle(null);
        game2.setStyle(null);
        game3.setStyle(null);
        game4.setStyle(null);
        game5.setStyle(null);
        game6.setStyle(null);
        game7.setStyle(null);
        game8.setStyle(null);
        game9.setStyle(null);
        game10.setStyle(null);
        game11.setStyle(null);
        game12.setStyle(null);
        game13.setStyle(null);
        game14.setStyle(null);
        game15.setStyle(null);
        homePlayer1.getItems().clear();
        homePlayer2.getItems().clear();
        awayPlayer1.getItems().clear();
        awayPlayer2.getItems().clear();
        enterScoresLabel.setText("");
        selectATeamLabel.setTextFill(Color.BLACK);
        selectATeamLabel.setText("Please select the teams");
        guideText.setText("Select an option below:");
        scoreSheetGridPane.setDisable(true);
        submitScoreSheet.setDisable(true);

    }

    
    
    
    // The function starts off by looking at the players entered on the scoreSheet, and validating them. (If they fail validation, a message is displayed)
    //Next, the game Textfields are validated. (The fields that pass validation are turnt green, and the others red. Validation is passed when all textFields are green)
    public void submitScoreSheetButtonPressed() {
        String hp1 = homePlayer1.getValue();
        String hp2 = homePlayer2.getValue();
        String ap1 = awayPlayer1.getValue();
        String ap2 = awayPlayer2.getValue();

        if (validatePlayers(hp1, hp2, ap1, ap2)) {
            int validationVariable = 0;
            TextField[] validateGames = {game1, game2, game3, game4, game5, game6, game7, game8, game9, game10, game11, game12, game13, game14, game15};
            for (TextField eachGame : validateGames) {
                if (validateTextField(eachGame.getText())) {
                    eachGame.setStyle("-fx-background-color: #25B32D;");
                } else {
                    eachGame.setStyle("-fx-background-color: #EB4934;");
                    validationVariable++;
                }
            }
            if (validationVariable != 0) {
                enterScoresLabel.setTextFill(Color.RED);
                enterScoresLabel.setText("Invalid entry below:");
                return;
            }
            //End of validation
            //Next, the textfield entries are collected as Strings, and passed into the createSheet() function alongside the player names. This function returns a ScoreSheet.
            //The final score is calculated after this.
            String g1 = game1.getText();
            String g2 = game2.getText();
            String g3 = game3.getText();
            String g4 = game4.getText();
            String g5 = game5.getText();
            String g6 = game6.getText();
            String g7 = game7.getText();
            String g8 = game8.getText();
            String g9 = game9.getText();
            String g10 = game10.getText();
            String g11 = game11.getText();
            String g12 = game12.getText();
            String g13 = game13.getText();
            String g14 = game14.getText();
            String g15 = game15.getText();

            ScoreSheet newScoreSheet = new ScoreSheet(g1,g2,g3,g4,g5,g6,g7,g8,g9,g10,g11,g12,g13,g14,g15,hp1,hp2,ap1,ap2);
            newScoreSheet.setFinalScores();

            //Then it searches for the fixture.
            //As the fixture was found previously (When create was pressed), this function simply relocates said fixture, updates the Teams stats for each team competing and sets the scoreSheet. 
            //The final score and winner are displayed and the scoreSheet is disabled.
            Fixture currentFixture = fixtureHandler.findFixture(homeTeam.getValue().getTeamName(),awayTeam.getValue().getTeamName());
            updateTeamStatsAndSetScoreSheet(newScoreSheet,currentFixture);
            disableScoreSheet();
            enterScoresLabel.setTextFill(Color.GREEN);
            enterScoresLabel.setText("Score Sheet sucessfully submitted!");
            createScoreSheet.setDisable(false);
            homeTeam.setDisable(false);
            awayTeam.setDisable(false);
            modifyScoreSheet.setDisable(false);

            if (newScoreSheet.getFinalScores()[0] > newScoreSheet.getFinalScores()[1]) {
                finalScore.setText("Home Team wins!:" + Arrays.toString(newScoreSheet.getFinalScores()));
            } else {
                finalScore.setText("Away Team wins!:" + Arrays.toString(newScoreSheet.getFinalScores()));
            }
        }

    }
    
    //This function takes in a scoreSheet and a fixture. It then updates the team stats for each team in the fixture given the results and saves the scoreSheet within the fixture 
    public void updateTeamStatsAndSetScoreSheet(ScoreSheet newScoreSheet,Fixture currentFixture)
    {
        
    if (newScoreSheet.getFinalScores()[0] > newScoreSheet.getFinalScores()[1]) {
        currentFixture.getHomeTeam().matchPlayed(true, newScoreSheet.getFinalScores()[0]);
        currentFixture.getAwayTeam().matchPlayed(false, newScoreSheet.getFinalScores()[1]);
    } else {
        currentFixture.getHomeTeam().matchPlayed(false, newScoreSheet.getFinalScores()[0]);
        currentFixture.getAwayTeam().matchPlayed(true, newScoreSheet.getFinalScores()[1]);
    }
    currentFixture.setScoreSheet(newScoreSheet);
    }
    
    
    
   
    ///////////////////////////////////////////
    //These functions are for the Viewer Page//
    ///////////////////////////////////////////

    //This function is called whenever the user selects a report from the ComboBox of reports.
    //A switch case statement is used in order to decide the appropriate report to display.
    //A check is made to see if the report has been generated to view, and if it is it will be displayed
    //If not, a message will be displayed, prompting them to generate the stats
    public void viewSelectedReport() {
        String selectedReport;
        if(selectReport.getValue() == null){
            reportTextArea.setText("Please select a report to view");
        }
        
        else{
        selectedReport = selectReport.getValue().toString();
        reportTextArea.clear();
        switch (selectedReport) {
            case "View Fixture and result chart":
                selectFixture.setVisible(false);
                if (reportHandler.getTeamStatsReport().equals(" ")) {
                    reportTextArea.setText("There is nothing to display, please generate Team Stats");
                } else {
                    reportTextArea.setText(reportHandler.getFixtureAndResultsChart());
                }
                break;
            case "Show all team stats":
                selectFixture.setVisible(false);
                if (reportHandler.getTeamStatsReport().equals(" ")) {
                    reportTextArea.setText("There is nothing to display, please generate Team Stats");
                } else {
                    reportTextArea.setText(reportHandler.getTeamStatsReport());
                }
                break;
            case "Show all team ranking":
                selectFixture.setVisible(false);
                if (reportHandler.getTeamRankingReport().equals(" ")) {
                    reportTextArea.setText("There is nothing to display, please generate Team Stats");
                } else {
                    reportTextArea.setText(reportHandler.getTeamRankingReport());
                }
                break;
            case "View a match scores":
                selectFixture.setVisible(true);
                reportTextArea.setText("Please select a fixture to view");
                break;
             
            default:
                break;
        }
    }
    }

    //This function is called when the user has selected a particular fixture to view.
    //A simple check is made which checks if the Fixture's scoreSheet has been created yet. If it hasn't, it will display a message saying so to the user.
    //If the scoreSheet has been entered, it isa displayed in the textArea.
    public void showFixture() {
        Fixture thisFixture = selectFixture.getValue();
        if (thisFixture.getScoreSheet() != null) {
            reportTextArea.setText(thisFixture.toString() + "\n" + thisFixture.getScoreSheet().toString());
        } else {
            reportTextArea.setText("This scoresheet has not been submitted yet");
        }
    }

    
    
    //////////////////////////////////////
    //These functions are for Validation//
    //////////////////////////////////////    
    
    //This validation is called on each "game" textfield. It simply checks if the input is recognised by the function that turns it into a score.
    //If so, the entry is valid and true is returned. Otherwise, if it raises an exception, false will be returned.
    public boolean validateTextField(String game) {
        Set ValidationSet = new Set("v1", "v2");
        try {
            ValidationSet.getScoresFromString(game);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    //The function is called when the submit scoresheet is button is pressed. It's job is to validate the names of the players entered on the scoreSheet.
    //If no player has been selected to fill a role (Either HP1,HP2,AP1 or AP2) an error message will be diplayed and the function will return false.
    //Otherwise, (If all players have been entered correctly) the function will return true.
    public boolean validatePlayers(String h1, String h2, String a1, String a2) {
        int validate = 0;
        if (h1 == null || h1.isEmpty()) {
            enterScoresLabel.setTextFill(Color.RED);
            enterScoresLabel.setText("Home player 1 has not been chosen");
            validate++;
        }
        if (h2 == null || h2.isEmpty()) {
            enterScoresLabel.setTextFill(Color.RED);
            enterScoresLabel.setText("Home player 2 has not been chosen");
            validate++;
        }
        if (a1 == null || a1.isEmpty()) {
            enterScoresLabel.setTextFill(Color.RED);
            enterScoresLabel.setText("Away player 1 has not been chosen");
            validate++;
        }
        if (a2 == null || a2.isEmpty()) {
            enterScoresLabel.setTextFill(Color.RED);
            enterScoresLabel.setText("Away player 2 has not been chosen");
            validate++;
        }

        if (validate == 0) {
            return true;
        } else {
            return false;
        }
    }
    
     //This function is used at the start of the create and modify a scoreSheet functions.
    //It performs a check to see if the user has entered two different teams when the press either button (create or modify).
    //If yes, the function will return true, else an error message will be displayed, and false is returned.
    public boolean validateTeams() {
        if (homeTeam.getValue() == null & awayTeam.getValue() == null) {
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("No teams are selected!");
            enterScoresLabel.setText("");

            return false;

        } else if (homeTeam.getValue() == null) {
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("No home team selected!");
            enterScoresLabel.setText("");
            return false;

        } else if (awayTeam.getValue() == null) {
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("No away team selected!");
            enterScoresLabel.setText("");
            return false;

        } else if (awayTeam.getValue() == (homeTeam.getValue())) {
            selectATeamLabel.setTextFill(Color.RED);
            selectATeamLabel.setText("Teams don't play themselves!");
            enterScoresLabel.setText("");
            return false;
        } else {

            return true;
        }

    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

        selectPlayerTeam.setItems(this.teamHandler.getTeamList());
        selectReport.getItems().addAll("View Fixture and result chart", "Show all team stats", "Show all team ranking", "View a match scores");
        homeTeam.setItems(this.teamHandler.getTeamList());
        awayTeam.setItems(this.teamHandler.getTeamList());
        selectFixture.setItems(fixtureHandler.getFixtureList());

        Team filton = new Team("filton");
        filton.addPlayer("alex");
        filton.addPlayer("brian");

        Team uwe = new Team("uwe");
        uwe.addPlayer("jin");
        uwe.addPlayer("julia");
        uwe.addPlayer("stewart");

        Team kcc = new Team("kcc");
        kcc.addPlayer("chris");
        kcc.addPlayer("ryan");

        Team page = new Team("page");
        page.addPlayer("peter");
        page.addPlayer("phil");

        teamHandler.getTeamList().add(filton);
        teamHandler.getTeamList().add(uwe);
        teamHandler.getTeamList().add(kcc);
        teamHandler.getTeamList().add(page);
        
        
        Runnable runnable = () -> {
            try {
                while (true) {
                    TimeUnit.SECONDS.sleep(100);
                    System.out.println("AutoGeneration has occured");
                    this.generateTeamStatsButtonPressed();
                }
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        };
        
        Thread teamstatstimer = new Thread(runnable);
        teamstatstimer.setDaemon(true);
        teamstatstimer.start();

    }

}
