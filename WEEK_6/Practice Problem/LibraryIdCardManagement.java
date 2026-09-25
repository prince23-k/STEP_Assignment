import java.util.Scanner;

class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class LibraryIdCardManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial books issued count: ");
        int initialCount = scanner.nextInt();

        IdCard ravi = new IdCard(name, initialCount);
        IdCard duplicate = ravi; // Points to the same object

        System.out.print("Enter updated books issued count via duplicate reference: ");
        int updatedCount = scanner.nextInt();
        duplicate.booksIssued = updatedCount;

        IdCard separate = new IdCard(name, updatedCount); // Separate object

        System.out.println("\n--- Output ---");
        System.out.println(name + "'s booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));

        scanner.close();
    }
}