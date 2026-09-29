package array.assignment_problems;

import java.util.Scanner;

public class ProductOfArrayExceptSelf {

    static int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix = prefix * nums[i];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix = suffix * nums[i];
        }

        return answer;
    }

    static void printArray(int[] arr) {

        System.out.print("[");

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);

            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("]");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] result = productExceptSelf(nums);

        System.out.print("Result: ");
        printArray(result);

        sc.close();
    }
}