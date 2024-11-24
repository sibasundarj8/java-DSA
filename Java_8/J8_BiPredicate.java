package Java_8;

import java.util.function.BiPredicate;
/** Evaluates this predicate on the given arguments.
 *  Params:   t – the first input argument
 *            u – the second input argument
 *  Returns:
 *  true if the input arguments match the predicate, otherwise false
 */
public class J8_BiPredicate {
    public static void main(String[] args) {

        // Both Odd
        BiPredicate<Integer, Integer> bothOdd = (i, j) -> i%2 == 1 && j%2 == 1;
        System.out.println(bothOdd.test(3, 5));

        // check if input String length equals with input Number
        BiPredicate<String, Integer> checkLength = (str, n) -> str.length() == n;
        System.out.println(checkLength.test("Siba", 4));
    }
}