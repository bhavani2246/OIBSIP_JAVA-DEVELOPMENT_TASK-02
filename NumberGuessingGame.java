import java.util.*;

public class NumberGuessingGame {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int totalScore = 0;
        int rounds;

        System.out.print("Enter number of rounds: ");
        rounds = sc.nextInt();

        for (int i = 1; i <= rounds; i++) {
            System.out.println("\n--- Round " + i + " ---");
            totalScore += playGame();
        }

        System.out.println("\nGame Over!");
        System.out.println("Your Total Score: " + totalScore);
    }

    public static int playGame() {

        Random rand = new Random();
        int numberToGuess = rand.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        int maxAttempts = 7;
        int score = 0;

        System.out.println("Guess a number between 1 and 100");
        System.out.println("You have " + maxAttempts + " attempts.");

        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int guess = sc.nextInt();
            attempts++;

            if (guess == numberToGuess) {
                System.out.println("Correct! You guessed the number.");

                // Score based on attempts
                score = (maxAttempts - attempts + 1) * 10;
                System.out.println("You scored: " + score);
                return score;

            } else if (guess < numberToGuess) {
                System.out.println("Too low!");

            } else {
                System.out.println("Too high!");
            }
        }

        System.out.println("You've used all attempts!");
        System.out.println("The correct number was: " + numberToGuess);

        return 0; // No score if failed
    }
}