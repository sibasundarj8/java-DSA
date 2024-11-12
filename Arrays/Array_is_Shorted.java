package Array;

import java.util.Scanner;

public class Array_is_Shorted {
    public Array_is_Shorted() {
    }

    static boolean shorted(int[] arr) {
        boolean check = true;
        int i;
        if (arr[1] < arr[0]) {
            for(i = 2; i < arr.length; ++i) {
                if (arr[i] > arr[i - 1]) {
                    check = false;
                    break;
                }
            }
        } else if (arr[1] > arr[0]) {
            for(i = 2; i < arr.length; ++i) {
                if (arr[i] < arr[i - 1]) {
                    check = false;
                    break;
                }
            }
        } else {
            for(i = 1; i < arr.length - 1; ++i) {
                if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1] || arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                    check = false;
                    break;
                }
            }
        }

        return check;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter array size :");
        int n = sc.nextInt();
        int[] num = new int[n];
        System.out.println("Enter array elements :");

        for(int i = 0; i < num.length; ++i) {
            num[i] = sc.nextInt();
        }

        System.out.println(shorted(num));
    }
}