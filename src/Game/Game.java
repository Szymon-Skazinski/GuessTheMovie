package Game;

public class Game {

    private String movieName;

    public Game( String movieName){

        this.movieName = movieName;
        gameStart();
    }


    void gameStart () {
        int movieNameLength = movieName.length();

        for (int i=0 ; i < movieNameLength ; i++){
            System.out.print('_');
        }


    }


}

