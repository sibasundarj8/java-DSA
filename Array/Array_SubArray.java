package Array;

import java.util.Scanner;

public class Array_SubArray {
    public Array_SubArray() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size :");
        int[] a = new int[sc.nextInt()];
        System.out.println("Enter Array Elements :");

        int s;
        for(s = 0; s < a.length; ++s) {
            a[s] = sc.nextInt();
        }

        System.out.println("Enter Sub-array Elements Sum :");
        s = sc.nextInt();
        int i = 0;
        int j = 0;

        for(int sum = 0; j < a.length; ++j) {
            sum += a[j];
            if (sum > s) {
                while(sum > s && i < j) {
                    sum -= a[i];
                    ++i;
                }
            }

            if (sum == s) {
                System.out.println("\nIndexes : " + i + " " + j);
                break;
            }
        }

    }
}