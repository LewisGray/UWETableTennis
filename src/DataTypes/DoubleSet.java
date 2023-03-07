/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataTypes;

import DataTypes.Set;

/**
 *
 * @author DELL
 */
public class DoubleSet extends Set {
    //Two more strings are added to represent the extra players competing in the set
    private String homePlayer2;
    private String awayPlayer2;

    
    public DoubleSet(String playerOne, String playerTwo,String playerThree,String playerFour) {
        super(playerOne, playerTwo);
        this.homePlayer2 = playerThree;
        this.awayPlayer2 = playerFour;
    }
    

    @Override
    public String toString() {
        Game[] games = super.getGames();
        return "Double Set{NULL vs NULL = "+games[0].toString()+","+games[1].toString()+","+games[2].toString()+"}" ;
    }
    

}
