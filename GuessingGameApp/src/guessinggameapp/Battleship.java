
package guessinggameapp;


public class Battleship extends BoardGame {
    public Battleship(){
        this.attributesOf[2] = true;
        this.attributesOf[3] = true;
        this.attributesOf[35] = true;

        this.name= "Battleship";
    }
}
