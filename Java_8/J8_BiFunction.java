package Java_8;

import java.util.function.BiFunction;
import java.util.function.Function;

/** Applies this function to the given arguments.
 *  Params: t – the first function argument
 *          u – the second function argument
 *  Returns:
 *  the function result
 */
public class J8_BiFunction {
    public static void main(String[] args) {

        // Total size of two Strings
        BiFunction<String, String, Integer> length = (x, y) -> x.length() + y.length();
        System.out.println(length.apply("Siba", "Anu"));    // 7

        // Chaining
        Function<Integer, Integer> square = i -> i*i;
        System.out.println(length.andThen(square).apply("Siba", "Anu"));    // 49
    }
}