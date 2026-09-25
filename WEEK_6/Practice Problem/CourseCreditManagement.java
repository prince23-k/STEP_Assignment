import java.util.Scanner;

class Course {
    String code;
    String title;
    int credits;
    int labCredits;

    // Direct Constructor (Theory + Lab)
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Theory-only Constructor chaining via this(...)
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return this.credits + this.labCredits;
    }
}

public class CourseCreditManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Theory-Only Course details:");
        System.out.print("Code: ");
        String tCode = scanner.nextLine();
        System.out.print("Title: ");
        String tTitle = scanner.nextLine();
        System.out.print("Credits: ");
        int tCredits = Integer.parseInt(scanner.nextLine());

        Course theoryCourse = new Course(tCode, tTitle, tCredits);

        System.out.println("\nEnter Theory + Lab Course details:");
        System.out.print("Code: ");
        String lCode = scanner.nextLine();
        System.out.print("Title: ");
        String lTitle = scanner.nextLine();
        System.out.print("Credits: ");
        int lCredits = Integer.parseInt(scanner.nextLine());
        System.out.print("Lab Credits: ");
        int labCredits = Integer.parseInt(scanner.nextLine());

        Course labCourse = new Course(lCode, lTitle, lCredits, labCredits);

        System.out.println("\n--- Credit Summary ---");
        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());

        scanner.close();
    }
}