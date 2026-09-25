import java.util.Scanner;

public class SeatDuplicationChecker {

    // Method to check duplicate seat numbers
    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        System.out.println("Duplicate Seat Numbers:");

        // Compare every element with the elements after it
        for (int i = 0; i < seatNumbers.length; i++) {

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {

                    System.out.println(
                        "Duplicate Seat Number Found: " + seatNumbers[i]
                    );

                    duplicateFound = true;
                    break;
                }
            }
        }

        // If no duplicate was found
        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] seatNumbers = new int[n];

        // Input seat numbers
        for (int i = 0; i < n; i++) {
            System.out.print("Enter seat number for student " + (i + 1) + ": ");
            seatNumbers[i] = sc.nextInt();
        }

        // Check duplicates
        checkDuplicateSeats(seatNumbers);

        sc.close();
    }
}