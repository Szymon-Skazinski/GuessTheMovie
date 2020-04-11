package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.Scanner;
import java.math.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("movie.txt");
        Scanner fileScanner = new Scanner(file);

        int lineCount = 0;
        while (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
            lineCount++;
        }

        String [] arrayMovie =  new String[lineCount];

        Scanner fileScanner2 = new Scanner(file);
        for (int i=0;i<lineCount ; i++){
            arrayMovie[i] = fileScanner2.nextLine();
        }

        int randomNumber = (int) (Math.random()*lineCount);             // random number from 0 to (lineCount)

        String randomMovie =  arrayMovie[1];
        System.out.println(randomNumber);
        System.out.println(randomMovie);

        Game newGame = new Game(randomMovie);


    }
}
