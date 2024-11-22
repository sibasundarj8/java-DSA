package Java_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
/// Represents a function that accepts one argument and produces a result.
public class J8_Functions {
    public static void main(String[] args) {


        /// Introduction to Functions

        // Length of a String
        Function<String, Integer> getLength = String :: length;
        System.out.println(getLength.apply("Anupama Maharana"));

        // First 4 Char
        Function<String, String> firstFour = x -> x.substring(0, 4);
        System.out.println(firstFour.apply("Sibasundar"));

        // Filter all Students name starts with "Siba".
        Function<List<Students>, List<Students>> filteredList = x -> {
            List<Students> res = new ArrayList<>();
            for (Students s : x){
                if (firstFour.apply(s.getName()).equals("Siba")){
                    res.add(s);
                }
            }
            return res;
        };
        Students s1 = new Students("Sibasundar", 236);
        Students s2 = new Students("Anupama", 237);
        Students s3 = new Students("Sibaprashad", 234);
        List<Students> s = Arrays.asList(s1, s2, s3);
        System.out.println(filteredList.apply(s));



        /// Function chaining

        // First 3 in Upper Case
        Function<String, String> upperCase = String :: toUpperCase;
        Function<String, String> first3 = x -> x.substring(0, 3);
        System.out.println(first3.andThen(upperCase).apply("Anupama"));

        // compose == !(andThen)
        Function<Integer, Integer> mul2 = x -> 2 * x;
        Function<Integer, Integer> cube = x -> x * x * x;
        System.out.println(mul2.andThen(cube).apply(5));    // 1000
        System.out.println(cube.andThen(mul2).apply(5));    // 250
        System.out.println(mul2.compose(cube).apply(5));    // 250



        /// Identity Function
        Function<String, String> idn = Function.identity();
        System.out.println(idn.apply("Anu"));
    }
    private static class Students{
        private int id;
        private String name;

        public Students(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Students{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
