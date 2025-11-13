import java.util.Random;
import java.util.Scanner;

public class NumberGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int lower = 1;
        int upper = 100;
        int maxAttempts = 7;
        int score = 0;
        String playAgain;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = rand.nextInt(upper - lower + 1) + lower;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nI'm thinking of a number between " + lower + " and " + upper + ".");
            System.out.println("You have " + maxAttempts + " attempts to guess it correctly!");

            while (attempts < maxAttempts) {
                System.out.print("\nAttempt " + (attempts + 1) + "/" + maxAttempts + " → Enter your guess: ");

                int guess;
                try {
                    guess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    sc.next(); // clear invalid input
                    continue;
                }

                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("🔻 Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("🔺 Too high! Try again.");
                } else {
                    System.out.println("✅ Correct! You guessed the number in " + attempts + " attempts.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1);
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The correct number was " + numberToGuess + ".");
            }

            System.out.println("Your current score: " + score);
            System.out.print("\nDo you want to play another round? (y/n): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("y"));

        System.out.println("\n🏁 Game Over! Your final score: " + score);
        System.out.println("Thanks for playing! 😊");

        sc.close();
    }
}
