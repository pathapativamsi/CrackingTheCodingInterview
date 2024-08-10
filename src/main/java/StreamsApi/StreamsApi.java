package StreamsApi;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamsApi {

    public int getSum(List<Integer> arr){
        Optional<Integer> sum = arr.stream().reduce((x, y)->x+y);
        return sum.get();
    }
    public static void main(String[] args) {
        List<Integer> intArr = Arrays.asList(1,4,5,6,22,3,41,5,11);

        StreamsApi streamsApi = new StreamsApi();
        System.out.println(streamsApi.getSum(intArr));

    }
}
