package Array;

import java.util.Scanner;

public class Array_Equal_Number_of_0s_and_1s_Largest_subArray1 {
    public Array_Equal_Number_of_0s_and_1s_Largest_subArray1() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Be careful!!! The Array Elements are only can be 0 or 1.\n Array Elements : ");

        int maxSize;
        for(maxSize = 0; maxSize < n; ++maxSize) {
            arr[maxSize] = sc.nextInt();
        }

        maxSize = -1;
        int sum = arr[0] == 0 ? -1 : 1;

        for(int i = 1; i < n; ++i) {
            if (arr[i] == 0) {
                --sum;
            } else {
                if (arr[i] != 1) {
                    throw new RuntimeException("Expected Element 0 or 1.");
                }

                ++sum;
            }

            if (sum == 0) {
                maxSize = i + 1;
            }
        }

        System.out.println(maxSize);
    }
}