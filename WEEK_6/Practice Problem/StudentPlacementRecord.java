import java.util.Scanner;

class PlacementRecord {
    String studentName;
    String company;
    double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class StudentPlacementRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlacementRecord[] records = new PlacementRecord[3];

        System.out.println("Enter details for 3 students (Name, Company, Package in LPA):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Student " + (i + 1) + " Name: ");
            String name = scanner.nextLine();
            System.out.print("Company: ");
            String company = scanner.nextLine();
            System.out.print("Package (LPA): ");
            double pkg = Double.parseDouble(scanner.nextLine());

            records[i] = new PlacementRecord(name, company, pkg);
        }

        System.out.println("\n--- Placement Records ---");
        for (PlacementRecord record : records) {
            record.printRecord();
        }

        scanner.close();
    }
}