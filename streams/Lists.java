package streams;
import java.util.Arrays;
import java.util.List;

public class Lists {
    private static void printSumOfList(List<Integer> nums){
        System.out.println("printing sum of list elements");
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        print(sum);
    }

    private static void printList(List<Integer> nums) {
        System.out.println("printing list elements");
        nums.stream().forEach(num -> System.out.println(num));
    }

    private static void print(int val) {
        System.out.println(val);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        printSumOfList(list);
        printList(list);
    }

}
