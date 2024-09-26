import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

class GameOfNumbers {
    int generateBySystem = 0;
    int guessByUser = 0;
    int noOfGuesses = 0;

    public int getNoOfGuesses()
    {
        return noOfGuesses;
    }

    public void setNoOfGuesses(int noOfGuesses)
    {
        this.noOfGuesses = noOfGuesses;
    }

    GameOfNumbers()
    {
        Random randomNumber = new Random();
        generateBySystem = randomNumber.nextInt(100);
    }

    void takeUserInput(Scanner sc)
    {
        System.out.println("Enter Your Guess : ");
        try 
        {
            guessByUser = sc.nextInt();
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input! Please enter an integer number.");
            sc.next();
        }
    }

    void checkUserGuess() 
    {
        noOfGuesses++;

        if (guessByUser < generateBySystem) 
        {
            System.out.println("Too low! Try again.\n");
        } 
        else if (guessByUser > generateBySystem) 
        {
            System.out.println("Too high! Try again.\n");
        } 
        else 
        {
            System.out.println("Congratulations! You guessed the correct number in " + noOfGuesses + " attempts.\n");
        }
    }
}

public class GuessTheNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GameOfNumbers game = new GameOfNumbers();

            while (game.guessByUser != game.generateBySystem) 
            {
                game.takeUserInput(sc);
                game.checkUserGuess();
            }
        sc.close();
    }
}
