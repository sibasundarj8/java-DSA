package Java_8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        System.out.println("\nfilter() -> even (1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9)");
        List<Integer> l1 = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9);
        List<Integer> filteredList = l1.stream()
                .filter(x -> x%2 == 0)
                .toList();
        System.out.println(filteredList);

        // Map -> Returns a stream consisting of the results of applying the given function to the elements of this stream.
        System.out.println("\nmap() -> x/2 " + filteredList);
        List<Integer> mappedList = filteredList.stream()
                .map(x -> x/2) // stateless operation
                .toList();
        System.out.println(mappedList);

        // Distinct -> Returns a stream consisting of the distinct elements
        System.out.println("\ndistinct() -> " + l1);
        List<Integer> distList = l1.stream()
                .distinct()
                .toList();
        System.out.println(distList);

        // Sort -> Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
        System.out.println("\nsorted() -> " + distList);
        List<Integer> sortList = distList.stream()
                .sorted((a, b) -> b-a) // stateful operation
                .toList();
        System.out.println(sortList);

        // Limit -> Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
        System.out.println("\nlimit(4) -> " + sortList);
        List<Integer> limitList = sortList.stream()
                .limit(4)
                .toList();
        System.out.println(limitList);

        /* Skip -> Returns a stream consisting of the remaining elements of this stream after discarding the first n
                    elements of the stream. If this stream contains fewer than n elements, then an empty stream will be
                    returned. */
        System.out.println("\nskip(4) -> " + sortList);
        List<Integer> limitList1 = sortList.stream()
                .skip(4)
                .toList();
        System.out.println(limitList1);

        /* Peek -> Returns a stream consisting of the elements of this stream, additionally performing the provided action
                   on each element as elements are consumed from the resulting stream. */
        System.out.println("\npeek() -> even (unique) " + l1);
        Stream<Integer> peek = l1.stream()
                .filter(n -> n % 2 == 0)
                .distinct()
                .peek(a -> System.out.print(a + " "));
        System.out.println("\n" + peek.toList());

        // Max -> Returns the last element of this stream after sorting, according to the provided Comparator.
        System.out.println("\nmax() -> " + list);
        int max = list.stream()
                .max(Comparator.comparingInt(a -> a))
                .get();
        System.out.println(max);

        // Min -> Returns the first element of this stream after sorting, according to the provided Comparator.
        System.out.println("\nmin() -> " + list);
        int min = list.stream()
                .min(Comparator.comparingInt(a -> -a))
                .get();
        System.out.println(min);

        // Count -> Returns the number of elements present in the stream.
        System.out.println("\ncount() -> even(unique)" + l1);
        long count = l1.stream()
                .filter(x -> x % 2 == 0)
                .distinct()
                .count();
        System.out.println(count);

        // ForEach -> iterate over each element
        System.out.println("\nforEach() -> unique odd (ele * 2) " + l1);
        l1.stream()
                .filter(a -> a%2 != 0)
                .distinct()
                .forEach(a -> System.out.print(a*2 + " "));

        // Reduce -> Combines elements to produce a single result
        System.out.println("\n\nreduce() -> sum of first digit from left of ele " + list);
        Optional<Integer> reduce = list.stream()
                .map(a -> a / (int)Math.pow(10, (int)Math.log10(a)))
                .reduce((x, y) -> x + y);
        System.out.println(reduce.get());

        // All_Match -> Checks all the elements satisfying the condition or not, Short the circuit at first mismatch.
        System.out.println("\nallMatch() -> all are divisible by 10 " + list);
        boolean b = list.stream()
                .allMatch(x -> x % 10 == 0);
        System.out.println(b);

        // Any_Match -> Checks any element satisfying the condition, Short the circuit at first match.
        System.out.println("\nanyMatch() -> any even present " + list);
        boolean b1 = list.stream()
                .anyMatch(x -> x % 2 == 0);
        System.out.println(b1);

        // None_Match -> Checks all elements not satisfying the condition, Short the circuit at first match.
        System.out.println("\nnoneMatch() -> each ele smaller then 0 " + list);
        boolean b2 = list.stream()
                .noneMatch(x -> x < 0);
        System.out.println(b2);

        // examples
        System.out.println("\nCount the number of 'a' in 'Sibasundar Jena'");
        String s = "Sibasundar Jena";
        IntStream chars = s.chars(); // convert String to an int array of ascii values of each character
        long count1 = chars
                .filter(ch -> ch == 'a')
                .count();
        System.out.println(count1);


        // Stateless operation: - A stateless operation doesn't need to know about any other element to be able to emit a result.
        //           Examples: filter(), map() or flatMap().
        // Stateful operations: - A stateful operations need to know about all the elements before emitting a result.
        //           Examples:  skip(), distinct(), limit() and sorted().


        // Lazy Evaluation
        List<String> list1 = List.of("Siba", "Jaga", "Anu", "Rahul", "Shasank", "Subrat", "Chiranjeeb", "Om", "Biswa", "Girighari");
        Stream<String> stringStream = list1.stream()
                .filter(string -> {
                    boolean flag = string.length() > 3;
                    System.out.println(string + " -> " + flag);
                    return flag;
                });
        System.out.println("\n------Before terminal operation------");
        List<String> list2 = stringStream
                .toList(); // filter operations are done
        System.out.println("------After terminal operation------");
        System.out.println(list2 + "\n");


        // Flat Map
        List<List<String>> listList = Arrays.asList(
                Arrays.asList("Siba", "Jaga", "Subrat", "Upendra"),
                Arrays.asList("Rahul", "Shasank", "Ujjwal", "Vansh"),
                Arrays.asList("Giridhari", "Biswa", "Om", "Chiranjeeb")
        );
        System.out.println("\nflatMap() -> combining words from multiple to single list ");
        listList.forEach(System.out :: println);
        System.out.print("Flatten: ");
        List<String> stringList = listList.stream()
                .flatMap(Collection :: stream).map(String :: toUpperCase)
                .toList();
        System.out.println(stringList + "\n");

        // Collect each word from different sentences to array
        List<String> stringList1 = Arrays.asList(
                "I am a CSE student",
                "I like JAVA",
                "I love coding",
                "I like spring boot"
        );
        stringList1.forEach(System.out :: println);
        System.out.println("------Separating words------");
        List<String> list3 = stringList1
                .stream()
                .flatMap(x -> Arrays.stream(x.split(" ")))
                .toList();
        System.out.println(list3);

        // forEachOrdered() -> used to avoid unordered iteration over parallel stream.
        System.out.println("\n------ForEach------");
        list
                .parallelStream()
                .forEach(x -> System.out.print(x + " "));
        System.out.println("\n------ForEachOrdered------");
        list
                .parallelStream()
                .forEachOrdered(x -> System.out.print(x + " "));
    }
}
