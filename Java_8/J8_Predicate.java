package Java_8;

import java.util.function.Predicate;

public class J8_Predicate {
    /// main Method
    public static void main(String[] args) {

        int number = 24;
        String s = "Sibasundar";

        /// to Check number is even or not
        Predicate<Integer> isEven = x -> x % 2 == 0;
        System.out.println(isEven.test(number));

        /// print all odd numbers
        for (int i = 0;i < number;i++){
            if (!isEven.test(i)){
                System.out.print(i + " ");
            }
        }
        System.out.println();

        ///  use predicate on Strings
        Predicate<String> firstCharS = x -> x.toLowerCase().charAt(0) == 's';
        Predicate<String> lastCharA = x -> x.toLowerCase().charAt(x.length()-1) == 'a';

        ///  Logical Operators
        Predicate<String> and = firstCharS.and(lastCharA);// firstCharS && lastCharA
        Predicate<String> or = firstCharS.or(lastCharA);  // firstCharS || lastCharA
        Predicate<String> negate = firstCharS.negate();   // !(firstCharS)

        System.out.println(and.test(s));
        System.out.println(or.test(s));
        System.out.println(negate.test("Anu"));

        /// isEqual()
        Predicate<String> pre = Predicate.isEqual("Siba");
        System.out.println(pre.test("Siba"));

        ///  use predicate on Classes
        Students s1 = new Students("Siba", 1);
        Students s2 = new Students("Anu", 2);

        Predicate<Students> student = x -> x.id() > 1;
        System.out.println(student.test(s1));
        System.out.println(student.test(s2));
    }
    
    private record Students(String name, int id){
    }
}
