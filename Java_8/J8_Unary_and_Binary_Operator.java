package Java_8;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class J8_Unary_and_Binary_Operator {
    public static void main(String[] args) {

    /// we can replace the functions with unary operators, which datatype of input and output is same.
        Function<Integer, Integer> square = x -> x * x;
        UnaryOperator<Integer> square1 = x -> x * x;    // Extends Function

    /// we can replace the bi-functions with binary operators, which datatype of inputs and output are same.
        BiFunction<String, String, String> concat = (x, y) -> x + " " + y;
        BinaryOperator<String> concat1 = (x, y) -> x + " " + y; // Extends Bi-Function

        System.out.println(square.apply(5));
        System.out.println(square1.apply(5));

        System.out.println(concat.apply("Hello", "World"));
        System.out.println(concat1.apply("Hello", "World"));
    }
}
