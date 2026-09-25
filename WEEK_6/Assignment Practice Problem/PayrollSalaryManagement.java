import java.util.Scanner;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double initialSalary) {
        if (initialSalary < 0) {
            System.out.println("Warning: Negative opening salary. Starting basic salary at 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = initialSalary;
        }
        this.bonus = 0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Bonus amount must be greater than 0.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Error: Tax percentage must be between 0 and 100.");
        } else {
            this.basicSalary -= (this.basicSalary * (percent / 100.0));
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class PayrollSalaryManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double salary = scanner.nextDouble();

        PayrollAccount account = new PayrollAccount(salary);

        System.out.print("Enter bonus amount: ");
        double bonus = scanner.nextDouble();
        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double tax = scanner.nextDouble();
        account.deductTax(tax);

        System.out.println("Net salary: Rs " + account.getNetSalary());

        scanner.close();
    }
}