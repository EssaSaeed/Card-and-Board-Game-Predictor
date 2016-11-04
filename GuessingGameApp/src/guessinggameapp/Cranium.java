package guessinggameapp;

public class Cranium extends BoardGame{
    public Cranium(){
        super();
        this.attributesOf[4] = true;
        this.attributesOf[3] = true;
        this.attributesOf[1] = true;
        this.attributesOf[12] = true;
        
        this.name= "Cranium";
    }
}
