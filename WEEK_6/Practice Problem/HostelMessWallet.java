import java.util.Scanner;

class MessWallet {
    private double balance;

    public MessWallet(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Top-up amount must be greater than 0.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Error: Deduct amount must be greater than 0.");
        } else {
            this.balance -= amount;
            System.out.println("Balance after deduction: " + this.balance);
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

public class HostelMessWallet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter opening balance: ");
        double opening = scanner.nextDouble();

        MessWallet wallet = new MessWallet(opening);

        System.out.print("Enter top-up amount: ");
        double topUpAmount = scanner.nextDouble();
        wallet.topUp(topUpAmount);

        System.out.print("Enter deduction amount: ");
        double deductAmount = scanner.nextDouble();
        wallet.deduct(deductAmount);

        System.out.println("Final balance: " + wallet.getBalance());

        scanner.close();
    }
}