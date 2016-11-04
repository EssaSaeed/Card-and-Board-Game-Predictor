
package guessinggameapp;

public class CardGame extends Game {        //Extends Game
    
    public CardGame() {
        super( false );       //Tells Game constructor that the isBoardGame attribute = false, because all extensions
                            //from this class are not boardGames, rather they are CardGames
        
    }
}
