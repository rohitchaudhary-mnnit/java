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

    private static void printLengthOfEachString(String[] arr) {
        System.out.println("Printing length of each string in the array");
        Arrays.stream(arr).forEach(s->System.out.println(s.length()));
    }

    private static void printSumOfLengthOfEachString(String[] arr) {
        System.out.println("Printing sum of length of each string in the array");
        int sum = Arrays.stream(arr).mapToInt(String::length).sum();
        System.out.println(sum);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5};
        printSumOfArray(nums);

        printArray(nums);

        String[] arr = new String[]{"MySQL", "Oracle", "Hbase", "Redis", "ElasticSearch", "Couchbase", "Cassandra"};
        printLengthOfEachString(arr);
        printSumOfLengthOfEachString(arr);
    }
}
