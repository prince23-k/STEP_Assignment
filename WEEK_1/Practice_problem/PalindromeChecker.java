import java.util.Scanner;

public class PalindromeChecker {

    // 1. Iterative Approach
    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // 2. Recursive Approach
    static boolean isPalindromeRecursive(String text) {

        // Base case
        if (text.length() <= 1) {
            return true;
        }

        // Compare first and last characters
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        // Recursive call after removing first and last character
        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    // 3. Array Reversal Approach
    static boolean isPalindromeArrayReversal(String text) {

        char[] arr = text.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        // Reverse the character array
        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println();

        System.out.println("Iterative: " +
                (iterative ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursive ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayReversal ? "Palindrome" : "Not Palindrome"));

        // Verify that all approaches agree
        if (iterative == recursive &&
            recursive == arrayReversal) {

            System.out.println("\nAll three approaches agree.");
        }

        sc.close();
    }
}