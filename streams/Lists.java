package streams;
import models.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    private static void getUniqueElements(List<Integer> list) {
        System.out.println("Getting unique elements from list:");
        List<Integer> filteredList = list.stream().collect(
                Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet().stream()
                .filter(e -> e.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(filteredList);
    }

    private static void maxLengthString(List<String> stringList) {
        String maxString = stringList.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        System.out.println(maxString+" has maximum length: "+maxString.length());
    }

    private static void getDistinctElements(List<Integer> list) {
        System.out.println("Getting distinct numbers from list");
        List<Integer> filteredList = list.stream().distinct().collect(Collectors.toList());
        System.out.println(filteredList);
    }

    private static void getMapWithFrequencyAsValues(List<Employee> employeeList) {
        System.out.println("Creating name frequency map from list of employees");
        Map<String, Long> map = employeeList.stream()
                .collect(Collectors.groupingBy(e -> e.getName(), Collectors.counting()));
        System.out.println(map);
    }

    private static void doubleSalaryOfEmployee(List<Employee> employeeList) {
        System.out.println("Doubling the salary of employees with odd id");
        System.out.println("Before doubling: "+employeeList);
        employeeList.stream().filter(e-> e.getId()%2==1).forEach(e-> e.setSalary(e.getSalary()*2));
        System.out.println("After doubling: "+employeeList);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,1,4,3);
        printSumOfList(list);
        printList(list);
        printListOptimized(list);
        getDistinctElements(list);

        List<String> strList = Arrays.asList("MySQL", "Oracle", "Hbase", "Redis", "ElasticSearch", "Couchbase", "Cassandra");
        printLengthOfEachString(strList);
        printSumOfLengthOfEachString(strList);
        getUniqueElements(list);
        maxLengthString(strList);

        Employee e1 = new Employee(1, "Rahul", 200000);
        Employee e2 = new Employee(2, "Rohit", 240000);
        Employee e3 = new Employee(3, "Rohit", 240000);
        Employee e4 = new Employee(4, "Rahul", 250000);
        Employee e5 = new Employee(5, "Rahul", 250000);

        List<Employee> employeeList = List.of(e1, e2, e3, e4, e5);
        getMapWithFrequencyAsValues(employeeList);
        doubleSalaryOfEmployee(employeeList);
    }

}
