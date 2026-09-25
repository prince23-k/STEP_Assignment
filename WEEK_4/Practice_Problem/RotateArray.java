import java.util.Scanner;
import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        k = k % nums.length;
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        return newArray;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        System.out.print("Enter rotation steps (k): ");
        int k = scanner.nextInt();

        int[] rotated = rotateArray(nums, k);
        System.out.println("Rotated Array: " + Arrays.toString(rotated));

        scanner.close();
    }
}