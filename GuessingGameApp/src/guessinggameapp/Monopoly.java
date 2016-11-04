
package guessinggameapp;

/**
 *
 * @author nelsa9456
 */
public class Monopoly extends BoardGame{
    
    public Monopoly(){
        super();
        this.attributesOf[4] = true;
        this.attributesOf[3] = true;
        this.attributesOf[7] = true;
        this.attributesOf[18] = true;
        
        this.name = "Monopoly";
    }
}
