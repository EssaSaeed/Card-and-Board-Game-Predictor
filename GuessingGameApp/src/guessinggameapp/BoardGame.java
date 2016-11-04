
package guessinggameapp;


public class BoardGame extends Game {       //Extends Game
    
    public BoardGame() {
        super( true );        //Tells Game constructor that the isBoardGame attribute = true, because all extension from this class are boardGames
         
    }
}
