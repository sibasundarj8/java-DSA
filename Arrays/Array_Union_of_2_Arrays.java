package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Union_of_2_Arrays {
    public Array_Union_of_2_Arrays() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array - A size : ");
        int[] a = new int[sc.nextInt()];
        System.out.print("Array A Elements : ");

        for(int i = 0; i < a.length; ++i) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter Array - B size : ");
        int[] b = new int[sc.nextInt()];
        System.out.print("Array B Elements : ");

        for(int i = 0; i < b.length; ++i) {
            b[i] = sc.nextInt();
        }

        int[] union = new int[a.length + b.length];
        int x = 0;

        for(int y = 0; x < union.length; ++x) {
            if (x < a.length)union[x] = a[x];
            else union[x] = b[y++];
        }

        Arrays.sort(union);
        System.out.print(union[0] + " ");
        int count = 1;

        for(int i = 1; i < union.length; ++i) {
            if (union[i] != union[i - 1]) {
                System.out.print(union[i] + " ");
                ++count;
            }
        }

        System.out.println("\nThere are " + count + " Elements present in Union Set");
    }
}