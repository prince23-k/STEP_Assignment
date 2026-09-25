import java.util.*;

public class RockPaperScissors {

    // Method to determine the winner
    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int n = 5;

        String[] moves = {"Rock", "Paper", "Scissors"};

        // Arrays to store round details
        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        // Play N rounds
        for (int i = 0; i < n; i++) {

            System.out.print("Round " + (i + 1) +
                    " - Enter Player Move (Rock/Paper/Scissors): ");

            playerMoves[i] = sc.next();

            // Generate computer move randomly
            computerMoves[i] = moves[random.nextInt(3)];

            // Determine result
            results[i] = playRound(playerMoves[i], computerMoves[i]);

            // Count results
            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.println("Computer Move: " + computerMoves[i]);
            System.out.println("Result: " + results[i]);
            System.out.println();
        }

        // Calculate win percentage
        double winPercentage = ((double) wins / n) * 100;

        // Final Summary
        System.out.println("========== FINAL SUMMARY ==========");

        System.out.printf("%-8s %-15s %-17s %-15s%n",
                "Round", "Player Move", "Computer Move", "Result");

        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-8d %-15s %-17s %-15s%n",
                    (i + 1),
                    playerMoves[i],
                    computerMoves[i],
                    results[i]);
        }

        System.out.println("----------------------------------------------------------");
        System.out.println("Wins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}