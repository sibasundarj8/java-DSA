package Array;

import java.util.Scanner;

public class Array_Two_Sum_for_sorted_Array {
    public Array_Two_Sum_for_sorted_Array() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Enter Array Elements : ");

        int t;
        for(t = 0; t < n; ++t) {
            arr[t] = sc.nextInt();
        }

        System.out.print("Enter Target : ");
        t = sc.nextInt();
        int i = 0;
        int j = n - 1;

        while(i < j) {
            if (arr[i] + arr[j] == t) {
                ++i;
                ++j;
                System.out.println(i + " " + j);
                return;
            }

            if (arr[i] + arr[j] > t) {
                --j;
            } else {
                ++i;
            }
        }

        System.out.println("pair not found...");
    }
}