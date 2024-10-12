package streams;

import java.util.Arrays;

public class Array {
    private static void printSumOfArray(int[] nums) {
        System.out.println("printing sum of array elements");
        int sum = Arrays.stream(nums).sum();
        print(sum);
    }

    private static void print(int val) {
        System.out.println(val);
    }

    private static void printArray(int[] nums) {
        System.out.println("printing array elements");
        Arrays.stream(nums).forEach(num -> System.out.println(num));
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        printSumOfArray(nums);

        printArray(nums);
    }
}
