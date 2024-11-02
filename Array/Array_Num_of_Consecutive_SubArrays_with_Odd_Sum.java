package Array;

import java.util.Scanner;

public class Array_Num_of_Consecutive_SubArrays_with_Odd_Sum {
    public Array_Num_of_Consecutive_SubArrays_with_Odd_Sum() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];
        System.out.print("Array Elements : ");

        int result;
        for(result = 0; result < arr.length; ++result) {
            arr[result] = sc.nextInt();
        }

        result = 0;

        for(int i = 0; i < arr.length; ++i) {
            int value = 0;

            for(int j = i; j < arr.length; ++j) {
                value += arr[j];
                if (value % 2 == 1) {
                    ++result;
                }
            }
        }

        System.out.println(result);
    }
}