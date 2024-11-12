package Generics;

public class Method_use {
    public static void main(String[] args) {
        Integer[]arr = {1,4,3,2,5,6};
        String[]brr = {"Hello","World"};

        printArray(arr);
        printArray(brr);
    }
    static <T> void printArray(T[]arr){
        for (T i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
}