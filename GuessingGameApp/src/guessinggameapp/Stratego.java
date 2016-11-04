
package guessinggameapp;


public class Stratego extends BoardGame{
    
    public Stratego(){
        super();
        this.attributesOf[3] = true;
        this.attributesOf[2] = true;
        this.attributesOf[32] = true;
        
        this.name="Stratego";
    }
}
