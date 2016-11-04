
package guessinggameapp;

import java.util.Scanner;       //Imports necessary Java functions (stuff)
import java.io.*;

public class GuessingGameApp {
    Game[] gameObjects = new Game[30];      //Initializes the gameObjects[] Array
    String[] questions = new String[38];        // 8+30 (8 main questions + 30 specific questions, one for each game)
    String answer;
    boolean gameNotGuessed = true;


    public void runGame() throws IOException {
        initialize();       //Fills Game[] Array and Questions[] Array
        possibleChoices();
        int questionCount = 0;      //Sets questionCount to zero to be called on later
        //System.out.println(gameObjects.length);
        while (gameNotGuessed == true){     //length of Game object array != 1;
            int indexOfQuestion = pickQuestion();       //Finds the best question to ask, and returns the index of it
            boolean user = askQuestion( indexOfQuestion );      //Asks the question and returns the user's response as a boolean
            questionCount += 1;     //QuestionCount increases by incrememnts of one for every question asked
            eliminateCandidate( indexOfQuestion, user ); //Doesn't need the game array as a argument as gameObjects is a field
            checkForAnswer();       //Checks to see if the game is over yet (if there is only one candidate left)
        }
        //
        System.out.println("Your game is " + answer  + " and I guessed it in " + questionCount + " questions.");
    }
    public int pickQuestion() {     //Finds the best question to ask, and returns the index of it
    
        int trueCount, falseCount;      //Initializes the trueCount and falseCount
        int questionIndex = 10000;      //Initializes the questionIndex at a value that will change, if it does not change it will
                                        //force an error to occur that will alert us about this method
        int lenArray = gameObjects[0].attributesOf.length;      //Obtains the length of the attributesOf Array
        double difference;      //Initializes the difference
        double lowestDifference = lenArray;       //Initializes the lowestDifference as the length of the attributesOf Array (it has to change throughout the method)
    
        for ( int i = 0; i < lenArray; i++ ) {      //A for-loop that goes through each of the attributes
            trueCount = 0;      //Sets trueCount to zero
            falseCount = 0;     //Sets falseCount to zero

            for( int j = 0; j < gameObjects.length; j++ ) {     //A for-loop that goes through each game's trues and falses to find the optimal question to ask
                if ( gameObjects[j].isPotentialAnswer ) {     //Only does any real calculations if the gameObject is still a candidate
                    if ( gameObjects[j].attributesOf[i] ) {       //Increases the trueCount if the attribute of the game is true
                    trueCount++;
                    }
                    else {      //Else, increases the falseCount if the  attribute of the game is false
                        falseCount++;
                    }
                }
            }
            //System.out.println("truCnt: " + trueCount);
            difference = Math.sqrt((trueCount - falseCount)*(trueCount - falseCount));   //Calculates the absolute value of the difference
            //System.out.println("dif: " + difference);
            if ( difference < lowestDifference ) {        //Compares difference with the lowestDifference, and replaces it if the current difference is lower
                lowestDifference = difference;	
                
                questionIndex = i;      //Sets questionIndex equal to the index of the last question asked that produced the lowest difference
            }
      
        }
        return questionIndex;       //Returns the questionIndex
    }

    public void eliminateCandidate(int indexOf,boolean userInput) {     //Eliminates the candidates by setting isPotentialAnswer to false if the user's input 
                                                                        //is contrary to the game's attribute
        for ( int a = 0; a < gameObjects.length; a++ ) {
            if ( gameObjects[a].attributesOf[indexOf] != userInput ) {
                gameObjects[a].isPotentialAnswer = false;
            } 
        }
    }
    public void checkForAnswer() {      //Checks to see if there is one answer
        int numPotentialAnswers = 0;
        for ( int a = 0; a < gameObjects.length; a++ ) {
            if ( gameObjects[a].isPotentialAnswer == true ) {
                numPotentialAnswers += 1;
            }
        }
        if ( numPotentialAnswers == 1 ) {       //If there is only one potential answer, it stores the name of it as 'answer' and sets gameNotGuessed to false
            for ( int a = 0; a < gameObjects.length; a++ ) {
                if ( gameObjects[a].isPotentialAnswer == true ) {
                    answer = gameObjects[a].name;
                    gameNotGuessed = false;
                }
            }
        }
    }

    public boolean askQuestion( int indexOfQuestion ) throws IOException {      //Asks the question and returns the user's answer as a boolean
        System.out.println( questions[indexOfQuestion] );
    
        Scanner user = new Scanner(System.in);
    
        String userInput = user.next();
    
        boolean response;
    
        if ( userInput.equalsIgnoreCase( "yes" ) ) {
            response = true;
        }
        else {
            response = false;
        }
        return response;
    }
    
    public void possibleChoices() {     //Displays the possible game choices at the beginning
        
        String afterName = ", "; //Will be what is displayed after the name of the game
        System.out.print( "Please choose a game from the following list: \n" );
        for (int a = 0; a < gameObjects.length; a++){
            if ( a == gameObjects.length - 1 ) {
                afterName = ".";
            }
            System.out.print( gameObjects[a].name + afterName );
            if ( a%5 == 4 && a < gameObjects.length - 4 ) {
                    System.out.println("\n");
            }
            
        }
        System.out.println("\n");
        
    }
    public void initialize() throws IOException {       //Fills the gameObjects Array with new games, and fills the questions Array from the file: 'Questions.txt'
    
        gameObjects[0] = new Monopoly();
        gameObjects[1] = new Stratego();
        gameObjects[2] = new Jumanji();
        gameObjects[3] = new MouseTrap();
        gameObjects[4] = new GameOfLife();
        gameObjects[5] = new Scrabble();
        gameObjects[6] = new Mahjong();
        gameObjects[7] = new Trouble();
        gameObjects[8] = new Cranium();
        gameObjects[9] = new Checkers();
        gameObjects[10] = new Shogi();
        gameObjects[11] = new Risk();
        gameObjects[12] = new OldMaid();
        gameObjects[13] = new President();
        gameObjects[14] = new Signal();
        gameObjects[15] = new Spoons();
        gameObjects[16] = new GoFish();
        gameObjects[17] = new Solitaire();
        gameObjects[18] = new CrazyEights();
        gameObjects[19] = new BlackJack();
        gameObjects[20] = new War();
        gameObjects[21] = new Cheat();
        gameObjects[22] = new Rummy();
        gameObjects[23] = new Poker();
        gameObjects[24] = new NinetyNine();
        gameObjects[25] = new Sorry();
        gameObjects[26] = new Chess();
        gameObjects[27] = new Battleship();
        gameObjects[28] = new Euchre();
        gameObjects[29] = new Hearts();
    
        FileReader file = new FileReader( "Questions.txt" );

        Scanner s = new Scanner( file );

        int i = 0;
        while ( s.hasNextLine() ) {
            questions[i] = s.nextLine();
            //System.out.println(questions[i]);
            i++;
        }
      }
    
    public static void main(String[] args) throws IOException {     //The Main method, that runs the program (calls on the other methods)
        Scanner u = new Scanner( System.in );
        boolean gameRunning = true;     //The gameRunning is set to true

        GuessingGameApp g = new GuessingGameApp();      //Creates a GuessingGameApp

        while ( gameRunning == true ) {     //While-loop that runs when the game is still not over
            System.out.println( "Welcome to the Game Guessing Game App! WARNING: If you enter" );
            System.out.println( "an answer besides 'yes' or 'no', it will be taken as a 'no'." );
            
            g.runGame();
            System.out.println( "Since you had so much fun playing this game, you are going to play again. Is this true or false?" );
            gameRunning = u.nextBoolean();
            g.gameNotGuessed = gameRunning;     //Replays the game if user enters true, by setting the gameRunning to true
         }
    }
}
