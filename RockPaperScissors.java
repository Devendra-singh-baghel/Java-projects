import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException;

class NewGame {
    int systemChoice = 0;
    int userChoice = 0;
    int computerWins = 0;
    int userWins = 0;
    String[] choices = { "Rock", "Scissors", "Paper" };

    void takeSystemChoice() 
    {
        Random randNum = new Random();
        systemChoice = randNum.nextInt(3);
    }

    void takeUserChoice(Scanner sc) 
    {
        while (true) 
        {
            System.out.println("0 for Rock,  1 for Scissors,  2 for Paper \n");
            System.out.print("Enter Your Choice : ");
            try 
            {
                userChoice = sc.nextInt();
                if (userChoice >= 0 && userChoice <= 2) 
                {
                    break;
                }
                else 
                {
                    System.out.println("Invalid Input! Please choose valid choice between 0 to 2");
                }
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input! Please enter an integer number.");
                sc.next();
            }
        }
    }

    void printChoices() 
    {
        System.out.println("Your Choice: " + choices[userChoice]);
        System.out.println("Computer Choice: " + choices[systemChoice]);
    }

    void gameRules() 
    {
        if (systemChoice == userChoice) 
        {
            System.out.println("Game Draw!");
        } 
        else if (systemChoice == 0 && userChoice == 1 || systemChoice == 1 && userChoice == 2 || systemChoice == 2 && userChoice == 0) 
        {
            System.out.println("Computer Win!");
            computerWins++;
        } 
        else 
        {
            System.out.println("You Win!");
            userWins++;
        }
    }

    void displaySeriesResult()
    {
        System.out.println("Final Results:");
        System.out.println("You won " + userWins + " times.");
        System.out.println("Computer won " + computerWins + " times.");

        if(computerWins > userWins)
        {
            System.out.println("Computer wins the series!");
        }
        else if(userWins > computerWins)
        {
            System.out.println("Congratulations You wins the series!");
        }
        else
        {
            System.out.println("The series is draw!");
        }
    }
}

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        NewGame play = new NewGame();

        int i = 0;
        while (i < 5) 
        {
            play.takeSystemChoice();
            play.takeUserChoice(sc);
            play.printChoices();
            play.gameRules();
            System.out.println();
            i++;
        }

        play.displaySeriesResult();
        sc.close();
    }
}

