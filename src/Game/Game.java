package Game;
import java.util.Scanner;

import static java.lang.Character.isWhitespace;

public class Game {

    private String movieName;
    private String hiddenName;          //underscored movieName
    private boolean isHidden;
    private String wrongGuess;
    private int wrongGuessCount;

    public Game(String movieName) {
        this.movieName = movieName;
        wrongGuessCount = 0;
        wrongGuess = "";
        isHidden = true;
        gameStart();

    }


    void gameStart() {
        int movieNameLength = movieName.length();
        wrongGuess = "";
        hiddenName = "";

        for (int i = 0; i < movieNameLength; i++) {                         // creating hiddenName (underscored)
            if (isWhitespace(movieName.charAt(i))) hiddenName += ' ';       //checkin if its space
            else hiddenName += '_';
        }

        System.out.println(hiddenName);

        while (isHidden == true) {
            letterReveal();
        }

        if (hiddenName.equalsIgnoreCase(movieName)) {
        System.out.println("You win");
        System.out.println("You have guessed '" + movieName + "' correctly");
        }
    }

    void letterReveal() {

        System.out.print("Guess a letter: ");
        Scanner scanner = new Scanner(System.in);

        char letter = scanner.next().charAt(0);             //letter - char input by user


        int index = 0;
        if (movieName.indexOf(letter)>=0) {
            while (movieName.indexOf(letter, index) >= 0) {     //checking each occurrence of letter
                index = movieName.indexOf(letter, index);
                if (index >= 0) {
                    hiddenName = hiddenName.substring(0, index) + letter + hiddenName.substring(index + 1, hiddenName.length());
                }
                index++;
            }
        } else if (wrongGuess.indexOf(letter) < 0) {
            wrongGuess = wrongGuess + " " +letter;
            wrongGuessCount ++;
        }

        System.out.println("You are guessing:" + hiddenName);
        System.out.println("You have guessed (" + wrongGuessCount + ") wrong letters:" + wrongGuess);

        if (hiddenName.indexOf('_') <0){
            isHidden = false;
        }

    }



}

