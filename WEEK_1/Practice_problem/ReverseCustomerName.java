import java.util.Scanner;

public class ReverseCustomerName {

    // Method to reverse the customer name
    static String reverseCustomerName(String customerName) {

        // Convert String into character array
        char[] arr = customerName.toCharArray();

        int left = 0;
        int right = arr.length - 1;

        // Reverse the array
        while (left < right) {

            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        // Convert character array back to String
        return new String(arr);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Call the method
        String reversedName = reverseCustomerName(customerName);

        // Print original and reversed name
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        sc.close();
    }
}