package Java_8;

import java.util.List;
import java.util.stream.Stream;

public class J8_Parallel_Stream {

    /// main Method
    public static void main(String[] args) {
        List<Integer> list = Stream.iterate(1, x -> x+1).limit(20000).toList();

        long startTime = System.currentTimeMillis(); // ~ 181 ms
        List<Integer> list1 = list.stream().map(J8_Parallel_Stream::totalSum).toList();
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");

        startTime = System.currentTimeMillis();      // ~ 20 ms
        List<Integer> list2 = list.parallelStream().map(J8_Parallel_Stream::totalSum).toList();
        endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime + " ms");
    }

    // factorial
    private static int totalSum (int n){
        int ans = 1;
        while (n > 0){
            ans *= n--;
        }
        return ans;
    }
}
