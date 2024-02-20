import java.util.Random;
import java.util.Scanner;
//First Task By HAJAR BOUSAKEN #Codsoft
public class GuessTheNumber {
    public static void main(String[] args) {
        try (var scanner = new Scanner(System.in)) {
            Random random = new Random();
            int minRange = 1;
            int maxRange = 100;
            int attemptsLimit = 10;
            int score = 0;
            
            System.out.println("Welcome to Guess the Number!");
            System.out.println("I have selected a number between " + minRange + " and " + maxRange + ".");
            
            boolean playAgain = true;
            while (playAgain) {
                int numberToGuess = random.nextInt(maxRange - minRange + 1) + minRange;
                int attempts = 0;
                boolean guessedCorrectly = false;
                
                while (!guessedCorrectly && attempts < attemptsLimit) {
                    System.out.print("Enter your guess: ");
                    int userGuess = scanner.nextInt();
                    attempts++;
                    
                    if (userGuess == numberToGuess) {
                        System.out.println("Congratulations! You guessed the number " + numberToGuess + " correctly!");
                        score += attemptsLimit - attempts + 1; // Score based on attempts taken
                        guessedCorrectly = true;
                    } else if (userGuess < numberToGuess) {
                        System.out.println("Too low! Try again.");
                    } else {
                        System.out.println("Too high! Try again.");
                    }
                }
                
                if (!guessedCorrectly) {
                    System.out.println("Sorry, you've run out of attempts. The correct number was: " + numberToGuess);
                }
                
                System.out.print("Do you want to play again? (yes/no): ");
                String playAgainChoice = scanner.next().toLowerCase();
                if (!playAgainChoice.equals("yes")) {
                    playAgain = false;
                }
            }
            
            System.out.println("Your final score is: " + score);
        }
    }
}
