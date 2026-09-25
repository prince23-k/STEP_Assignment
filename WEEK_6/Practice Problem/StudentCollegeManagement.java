import java.util.Scanner;

class Student {
    String name;
    double attendance;

    static String collegeName = "SRM Institute of Science and Technology";
    static int studentCount = 0;

    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentCollegeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter details for Student 1:\nName: ");
        String name1 = scanner.nextLine();
        System.out.print("Attendance: ");
        double att1 = Double.parseDouble(scanner.nextLine());
        new Student(name1, att1);

        System.out.print("\nEnter details for Student 2:\nName: ");
        String name2 = scanner.nextLine();
        System.out.print("Attendance: ");
        double att2 = Double.parseDouble(scanner.nextLine());
        new Student(name2, att2);

        System.out.println("\n2 Student objects created\n");
        Student.printCollegeInfo();

        scanner.close();
    }
}