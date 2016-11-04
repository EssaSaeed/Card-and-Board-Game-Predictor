
package guessinggameapp;


public class Game {
 
    boolean isPotentialAnswer; 
    boolean[] attributesOf = new boolean[38];
    String name;
    
    public Game( boolean a ) {        //Contructor for Game
        attributesOf[0] = a;        //Sets the isBoardGame attribute to whatever 'a' is
        this.isPotentialAnswer = true;      //Makes all the games a potentialAnswer to start
        
        for ( int b = 1; b < attributesOf.length; b++ ) {       //Fills the game attributes array other than the first with falses
            attributesOf[b] = false;
        }
    }
}

