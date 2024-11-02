package Array;

import java.util.Scanner;

public class Array_Middle_Element {
    public Array_Middle_Element() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];
        System.out.print("Array Elements : ");

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }

        middleElement(arr);
    }

    static void middleElement(int[] arr) {
        int[] left = new int[arr.length];

        for(int i = 1; i < left.length; ++i) {
            left[i] = left[i - 1] + arr[i - 1];
        }

        int[] right = new int[arr.length];

        int i;
        for(i = right.length - 2; i >= 0; --i) {
            right[i] = right[i + 1] + arr[i + 1];
        }

        for(i = 0; i < arr.length; ++i) {
            if (right[i] == left[i]) {
                System.out.println(arr[i]);
                return;
            }
        }

        System.out.println("No middle Element found!!!");
    }
}