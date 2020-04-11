package Game;
import java.util.Scanner;

import static java.lang.Character.isWhitespace;

public class Game {

    private String movieName;
    private String hiddenName;          //underscored movieName
    private String wrongGuess;          //String storing wrong char inputed by user
    private int wrongGuessCount;        //count of uniqe char in wrongGuess
    private int point;

    public Game(String movieName) {
        this.movieName = movieName;
        point = 10;
        wrongGuessCount = 0;
        wrongGuess = "";
        hiddenName = "";
        gameStart();
    }


    void gameStart() {
        int movieNameLength = movieName.length();

        for (int i = 0; i < movieNameLength; i++) {                         // creating hiddenName (underscored)
            if (isWhitespace(movieName.charAt(i))) hiddenName += ' ';       //checkin if its space
            else hiddenName += '_';
        }

        System.out.println(hiddenName);

        while (point>0 && !(hiddenName.equalsIgnoreCase(movieName)) ) {
            letterReveal();
        }

        if (hiddenName.equalsIgnoreCase(movieName)) {
        System.out.println("You win! Your score is: " + point);
        System.out.println("You have guessed '" + movieName + "' correctly");
        } else if(point == 0){
           System.out.println("You have defeated");
        }
    }

    void letterReveal() {
        System.out.print("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);
        boolean isCharCorrect = false;
        char character = scanner.next().charAt(0);                                               //character - char inputed by user
        if ((character >= 'A' && character <='Z') || (character >= 'a' && character <= 'z')) {   //checking if character variable is a letter
            isCharCorrect = true;
        } else System.out.println("Invalid symbol. Input the letter.");


        int index = 0;
        if (movieName.indexOf(character)>=0 && isCharCorrect) {
            while (movieName.indexOf(character, index) >= 0) {     //checking each occurrence of correct letter
                index = movieName.indexOf(character, index);
                if (index >= 0) {
                    hiddenName = hiddenName.substring(0, index) + character + hiddenName.substring(index + 1, hiddenName.length());
                }
                index++;
            }
        } else if (wrongGuess.indexOf(character) < 0 && isCharCorrect) {        //checking if wrong letter exist in wrongGuess
            wrongGuess = wrongGuess + " " +character;
            wrongGuessCount ++;
            point --;
        } else  System.out.println("You have already tried with this letter. Try another.");

        if (isCharCorrect) {
            System.out.println("You are guessing:" + hiddenName); }
        System.out.println("You have guessed (" + wrongGuessCount + ") wrong letters:" + wrongGuess);


    }

}

