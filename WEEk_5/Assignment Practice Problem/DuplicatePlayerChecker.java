import java.util.Scanner;

public class DuplicatePlayerChecker {

    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of players in lineup: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        String[] lineup = new String[n];
        System.out.println("Enter player names:");
        for (int i = 0; i < n; i++) {
            lineup[i] = scanner.nextLine();
        }

        String result = findDuplicatePick(lineup);
        System.out.println(result);

        scanner.close();
    }
}