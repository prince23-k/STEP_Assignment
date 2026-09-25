import java.util.Scanner;

public class ProductInventoryParser {

    public static void parseInventoryRecord(String csvLine) {
        if (csvLine == null) {
            System.out.println("Invalid Record");
            return;
        }

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        System.out.println("Product: " + fields[0].trim() + 
                           " | SKU: " + fields[1].trim() + 
                           " | Qty: " + fields[2].trim());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter inventory CSV line (ProductName,SKU,Quantity): ");
        String csvLine = scanner.nextLine();

        parseInventoryRecord(csvLine);

        scanner.close();
    }
}