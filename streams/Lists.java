package streams;
import java.util.Arrays;
import java.util.List;

public class Lists {
    private static void printSumOfList(List<Integer> nums){
        System.out.println("printing sum of list elements");
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        //print sumOf elements skipping 2 integers from first
        int skipSum = nums.stream().mapToInt(Integer::intValue).skip(2).sum();
        print(sum);
        print(skipSum);
    }

    private static void printList(List<Integer> nums) {
        System.out.println("printing list elements");
        nums.stream().forEach(num -> System.out.println(num));
    }

    private static void printListOptimized(List<Integer> nums) {
        System.out.println("printing list of elements in optimised way.");
        nums.forEach(System.out::println);
    }

    private static void printLengthOfEachString(List<String> list) {
        System.out.println("Printing length of each string in the list");
        list.stream().map(str -> str.length()).forEach(System.out:: println);
    }
    
    private static void printSumOfLengthOfEachString(List<String> list) {
        System.out.print("Sum of length of each string in the list: ");
        int sum = list.stream().mapToInt(String::length).sum();
        print(sum);
    }

    private static void print(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        printSumOfList(list);
        printList(list);
        printListOptimized(list);

        List<String> strList = Arrays.asList("MySQL", "Oracle", "Hbase", "Redis", "ElasticSearch", "Couchbase", "Cassandra");
        printLengthOfEachString(strList);
        printSumOfLengthOfEachString(strList);
    }

}
