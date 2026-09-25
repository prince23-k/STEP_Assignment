import java.util.Scanner;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter initial seat number: ");
        int initialSeat = scanner.nextInt();

        HallTicket priya = new HallTicket(name, initialSeat);
        HallTicket copy = priya; // Same reference

        System.out.print("Enter updated seat number via copy reference: ");
        int newSeat = scanner.nextInt();
        copy.seatNumber = newSeat;

        HallTicket separate = new HallTicket(name, newSeat); // Separate object

        System.out.println("\n--- Output ---");
        System.out.println(name + "'s seatNumber (via first variable): " + priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));
        System.out.println("separate == priya: " + (separate == priya));

        scanner.close();
    }
}