package Generics;

import java.util.Arrays;
import java.util.List;

public class Wildcards {
    public static void main(String[] args) {
        List<String> a = Arrays.asList("Hello","World","Siba");
        print(a);

        List<Number> b = Arrays.asList(2,2.4,35);
        printNumbers(b);
        printNumbers1(b);
    }
    static void print(List<?> a){
        for (Object i : a)
            System.out.print(i + " ");
        System.out.println();
    }
    // extends ->  upper bound
    static void printNumbers(List<? extends Number>a){
        for (Object o : a)
            System.out.print(o + " ");
        System.out.println();
    }
    // super ->  lower bound
    static void printNumbers1(List<? super Integer>a){
        for (Object o : a)
            System.out.print(o + " ");
        System.out.println();
    }
}