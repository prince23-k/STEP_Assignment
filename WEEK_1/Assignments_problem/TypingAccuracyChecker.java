import java.util.Scanner;

public class TypingAccuracyChecker {

    // Method to check typing accuracy
    static void checkTypingAccuracy(String original, String typed) {

        int matched = 0;
        int firstMismatch = -1;

        // Compare characters position by position
        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matched++;
            } 
            else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        // Calculate accuracy
        double accuracy = ((double) matched / original.length()) * 100;

        // Print result
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%%",
                matched, original.length(), accuracy);

        if (firstMismatch == -1) {
            System.out.println(" | No Mismatches");
        } 
        else {
            System.out.println(
                " | First Mismatch at position " +
                (firstMismatch + 1) +
                " ('" + original.charAt(firstMismatch) +
                "' vs '" + typed.charAt(firstMismatch) + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        // Check equal length
        if (original.length() != typed.length()) {
            System.out.println("Error: Both strings must have equal length.");
        } 
        else {
            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}