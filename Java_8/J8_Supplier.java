package Java_8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
/// Represents a supplier of results.
public class J8_Supplier {
    public static void main(String[] args) {

        // Supplier supplies the num.
        Supplier<Integer> num = () -> 200;
        System.out.println(num.get());

        /// use all
        Predicate<Integer> predicate = x -> x % 2 == 0;
        Function<Integer, Integer> function = x -> x * x;
        Consumer<Integer> consumer = System.out :: println;
        Supplier<Integer> supplier = () -> 24;

        if (predicate.test(supplier.get())){                    // Testing 24 is odd or even
            consumer.accept(function.apply(supplier.get()));    // printing the square of supplier
        }
    }
}
