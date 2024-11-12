package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Smallest_and_Largest_Element {
    public Array_Smallest_and_Largest_Element() {
    }

    static int[] Smallest(int[] arr) {
        Arrays.sort(arr);
        return new int[]{arr[0], arr[arr.length - 1]};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size :");
        int n = sc.nextInt();
        int[] num = new int[n];
        System.out.println("Enter " + n + " Elements :");

        for(int i = 0; i < num.length; ++i) {
            num[i] = sc.nextInt();
        }

        int[] ans = Smallest(num);
        System.out.println("Smallest is : " + ans[0]);
        System.out.println("Largest is : " + ans[1]);
    }
}