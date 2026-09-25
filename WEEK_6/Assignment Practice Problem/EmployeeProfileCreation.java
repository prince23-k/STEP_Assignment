import java.util.Scanner;

class Employee {
    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Permanent Employee Constructor
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Intern Constructor chaining via this(...)
    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeProfileCreation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Permanent Employee details:");
        System.out.print("ID: ");
        String pId = scanner.nextLine();
        System.out.print("Name: ");
        String pName = scanner.nextLine();
        System.out.print("Salary: ");
        double pSalary = Double.parseDouble(scanner.nextLine());

        Employee permEmp = new Employee(pId, pName, pSalary);

        System.out.println("\nEnter Intern details:");
        System.out.print("ID: ");
        String iId = scanner.nextLine();
        System.out.print("Name: ");
        String iName = scanner.nextLine();

        Employee internEmp = new Employee(iId, iName);

        System.out.println("\n--- Employee Profiles ---");
        permEmp.printProfile();
        internEmp.printProfile();

        scanner.close();
    }
}