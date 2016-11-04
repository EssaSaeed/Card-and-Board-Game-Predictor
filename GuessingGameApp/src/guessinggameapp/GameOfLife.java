
package guessinggameapp;

public class GameOfLife extends BoardGame{
    
    public GameOfLife(){
        super();
        this.attributesOf[4] = true;
        this.attributesOf[3] = true;
        this.attributesOf[14] = true;
        
        this.name="Life";
    }
}   
