package Java_8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
/// Represents an operation that accepts a single input argument and returns no result.
/// Unlike most other functional interfaces, Consumer is expected to operate via side effects.
public class J8_Consumer {
    public static void main(String[] args) {

        // Print the consumed String
        Consumer<String> print = System.out :: println;
        print.accept("Anupama");

        // Adding 100 to each element
        Consumer<List<Integer>> add100 = x -> {
            for (int i : x){
                System.out.print((i+100) + " ");
            }
            System.out.println();
        };
        Consumer<List<Integer>> printList = x -> {
            for (int i : x){
                System.out.print(i + " ");
            }
            System.out.println();
        };
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        printList.andThen(add100).accept(list);
    }
}
