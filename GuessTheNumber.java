import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;
        int totalRoundsWon = 0;

        while (playAgain) {
            int lowerlimit = 1;
            int upperlimit = 100;
            int randomNumber = random.nextInt(upperlimit - lowerlimit + 1) + lowerlimit;
            int tries = 0;
            int maximumtries = 10;
            boolean correcttry = false;

            System.out.println("....Welcome to the Number Game....");
            System.out.println("The game has generated a number between " + lowerlimit + " and " + upperlimit + ".");
            System.out.println("You have " + maximumtries + " attempts to guess it correctly.");

            while (tries < maximumtries && !correcttry) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                tries++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number " + randomNumber + " in " + tries + " attempts.");
                    correcttry = true;
                    totalRoundsWon++;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again. Attempts left: " + (maximumtries - tries));
                } else {
                    System.out.println("Too high! Try again. Attempts left: " + (maximumtries - tries));
                }
            }

            if (!correcttry) {
                System.out.println("Sorry, the number of attempts are over. The number was " + randomNumber + ".");
            }

            System.out.println("Your current score: " + totalRoundsWon + " rounds won.");
            System.out.print("Do you want to play another round? (yes/no): ");
            String playChoice = sc.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
            }
            System.out.println();
        }

        System.out.println("Thank you for playing! Your final score is " + totalRoundsWon + " rounds won.");
        sc.close();
    }
}
