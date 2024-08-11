package StreamsApi;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamsApi {

    public static class Student{
        int id;
        String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return"id is"+id+"name is"+name;
        }
    }

    public int getSum(List<Integer> arr){
        Optional<Integer> sum = arr.stream().reduce((x, y)->x+y);
        return sum.get();
    }

    public double getAvg(List<Integer> arr){
        return arr.stream().mapToInt(e -> e).average().getAsDouble();
    }

    public List<Integer> getSquare(List<Integer> arr){
        return arr.stream().map(e -> e*e).filter(x -> x>100).collect(Collectors.toList());
    }

    public List<Integer> findNumberIfStartsWith(List<Integer> arr, int startsWith){
        //return arr.stream().map(x -> String.valueOf(x)).filter(x -> x.startsWith(String.valueOf(startsWith))).map(x -> Integer.valueOf(x)).collect(Collectors.toList());
        return arr.stream().map(String::valueOf).filter(x -> x.startsWith(String.valueOf(startsWith))).map(Integer::valueOf).collect(Collectors.toList());

    }

    public Set<Integer> printDuplicateNumbers(List<Integer> arr){
        return arr.stream().filter(x -> Collections.frequency(arr,x) > 1).collect(Collectors.toSet());
    }

    public int getMaxVlue(List<Integer> arr){
        return arr.stream().max(Comparator.comparing(Integer:: valueOf)).get();
    }

    public List<Integer> sortList(List<Integer> arr){
        //return arr.stream().sorted().toList();
        //sort list and get only 5
        return arr.stream().sorted().limit(3).toList();
    }

    public static void main(String[] args) {
        List<Integer> intArr = Arrays.asList(1,4,5,6,22,3,41,5,11);

        StreamsApi streamsApi = new StreamsApi();
        System.out.println(streamsApi.getSum(intArr));
        System.out.println(streamsApi.getAvg(intArr));
        System.out.println(streamsApi.getSquare(intArr));
        System.out.println(streamsApi.findNumberIfStartsWith(intArr,1));
        System.out.println(streamsApi.printDuplicateNumbers(intArr));
        System.out.println(streamsApi.getMaxVlue(intArr));
        System.out.println(streamsApi.sortList(intArr));

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"vamsi"));
        students.add(new Student(1,"prasanna"));
        students.add(new Student(1,"prasanna"));
        students.add(new Student(1,"vamsi"));
        students.add(new Student(1,"vamsi"));
        students.add(new Student(1,"prasanna"));
        students.add(new Student(1,"prasanna"));

        System.out.println(students.stream().collect(Collectors.groupingBy(student -> student.name, Collectors.mapping(Student::getName, Collectors.toList()))));

    }
}
