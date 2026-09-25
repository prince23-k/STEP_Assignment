import java.util.Scanner;
import java.util.Arrays;

public class FantasyScoreMultiplier {

    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores != null) {
            if (captainIndex >= 0 && captainIndex < playerScores.length) {
                playerScores[captainIndex] *= 2.0;
            }
            if (viceCaptainIndex >= 0 && viceCaptainIndex < playerScores.length) {
                playerScores[viceCaptainIndex] *= 1.5;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] scores = {40.0, 55.0, 30.0, 62.0};
        System.out.println("Original scores: " + Arrays.toString(scores));

        System.out.print("Enter Captain index (0 to 3): ");
        int cap = scanner.nextInt();

        System.out.print("Enter Vice-Captain index (0 to 3): ");
        int vcap = scanner.nextInt();

        applyMultipliers(scores, cap, vcap);
        System.out.println("Boosted scores: " + Arrays.toString(scores));

        scanner.close();
    }
}