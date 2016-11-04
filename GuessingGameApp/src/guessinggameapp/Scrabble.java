package guessinggameapp;

public class Scrabble extends BoardGame {
    
    public Scrabble(){
        
        super();
        this.attributesOf[3] = true;
        this.attributesOf[1] = true;
        this.attributesOf[26] = true;
        
        this.name="Scrabble";
    }
}
