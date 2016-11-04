package guessinggameapp;

public class Checkers extends BoardGame{
    public Checkers(){
        super();
        this.attributesOf[3] = true;
        this.attributesOf[2] = true;
        this.attributesOf[10] = true;
        
        this.name= "Checkers";
    }
}
