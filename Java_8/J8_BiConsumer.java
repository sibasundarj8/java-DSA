package Java_8;

import java.util.function.BiConsumer;
/** Performs this operation on the given arguments.
 * Params:
 *          t – the first input argument
 *          u – the second input argument
 */
public class J8_BiConsumer {
    public static void main(String[] args) {

        // print X to the power Y
        BiConsumer<Integer, Integer> power = (x, y) -> System.out.println((int)Math.pow(x, y));
        power.accept(5, 2);

        // print SquareRoot of X
        BiConsumer<Integer, Integer> sqrt = (x, y) -> System.out.println(x * y);
        power.andThen(sqrt).accept(3, 3);
    }
}