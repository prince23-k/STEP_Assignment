import java.util.Scanner;

class CompanyEmployee {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of employees to add: ");
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Employee " + (i + 1) + " Name: ");
            String name = scanner.nextLine();
            System.out.print("Employee " + (i + 1) + " Salary: ");
            double salary = Double.parseDouble(scanner.nextLine());

            new CompanyEmployee(name, salary);
        }

        System.out.println("\n" + n + " Employee objects created\n");
        CompanyEmployee.printCompanyInfo();

        scanner.close();
    }
}