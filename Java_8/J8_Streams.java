package Java_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream:
 *      1.Readability
 *      2.Flexibility
 *      3.Parallelism
 *      4.Encapsulation
 */
public class J8_Streams {
    public static void main(String[] args) {

        int[]arr = {1,2,3,4,5,6,7,8,9};
        int oddSum = 0;

        //  Using for
        for (int i : arr){
            if (i%2 == 1){
                oddSum += i;
            }
        }
        System.out.println(oddSum);

        // Using Stream
        oddSum = Arrays.stream(arr).filter(n -> n%2 == 1).sum();
        System.out.println(oddSum);


    /// Conversion of Stream

        // Converting List to Stream
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        Stream<Integer> listStream = list.stream();
        System.out.println(listStream.toList());

        // Converting Array to Stream
        String[]array = {"Siba", "Anu"};
        Stream<String> arrayStream = Arrays.stream(array);
        System.out.println(arrayStream.toList());

    /// Creation of Stream
        Stream<Integer> integerStream = Stream.of(100, 200, 300, 400, 500);
        Stream<Integer> limit = Stream.iterate(5, n -> n + 5).limit(10);
        Stream<Integer> limit1 = Stream.generate(() ->  (int)(Math.random() * 10)).limit(4);
        System.out.println(integerStream.toList());
        System.out.println(limit.toList());
        System.out.println(limit1.toList());


    /// Different Functions of Stream

        // Filter - Returns a stream consisting of the elements of this stream that match the given predicate
        List<Integer> l1 = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);
        List<Integer> filteredList = l1.stream().filter(x -> x%2 == 0).toList();
        System.out.println(filteredList);

        // Map -> Returns a stream consisting of the results of applying the given function to the elements of this stream.
        List<Integer> mappedList = filteredList.stream().map(x -> x/2).toList();
        System.out.println(mappedList);

        // Distinct -> Returns a stream consisting of the distinct elements
        List<Integer> distList = l1.stream().distinct().toList();
        System.out.println(distList);

        // Sort -> Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
        List<Integer> sortList = distList.stream().sorted((a, b) -> b-a).toList();
        System.out.println(sortList);

        // Limit -> Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
        List<Integer> limitList = sortList.stream().limit(4).toList();
        System.out.println(limitList);

        /* Skip -> Returns a stream consisting of the remaining elements of this stream after discarding the first n
                    elements of the stream. If this stream contains fewer than n elements then an empty stream will be
                    returned. */
        List<Integer> limitList1 = sortList.stream().skip(4).toList();
        System.out.println(limitList1);

        /* Peek -> Returns a stream consisting of the elements of this stream, additionally performing the provided action
                   on each element as elements are consumed from the resulting stream. */
        Stream<Integer> peek = l1.stream().filter(n -> n % 2 == 0).distinct().peek(System.out::println);
        System.out.println(peek.toList());

        // Max -> Returns the maximum element of this stream according to the provided Comparator.
        int max = list.stream().max(Comparator.comparingInt(a -> a)).get();
        System.out.println(max);
    }
}
