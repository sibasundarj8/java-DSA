package Array;

import java.util.Scanner;

public class Array_Missing_Number {
    static int missingNumber(int[] arr, int n) {
        int sum = 0;
        for(int i = 0; i < n - 1; ++i)
            sum += arr[i];

        return n * (n + 1) / 2 - sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size : ");
        int[] num = new int[sc.nextInt()];

        int n = num.length + 1;

        System.out.println("Enter Array Elements : ");
        System.out.println("1. numbers range : 1 - n+1");
        System.out.println("2. Repeated Numbers are not Allowed");
        for(int i = 0; i < num.length; ++i)
            num[i] = sc.nextInt();

        System.out.println(missingNumber(num, n));
    }
}