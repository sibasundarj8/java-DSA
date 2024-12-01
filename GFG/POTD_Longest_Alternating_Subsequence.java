package GFG;/*
 *   Q. You are given an array arr. Your task is to find the longest length of a good sequence.
 *      A good sequence {x1, x2, ... xn} is an alternating sequence
 *      if its elements satisfy one of the following relations:
 *                      1.  x1 < x2 > x3 < x4 > x5. . . . . and so on
 *                      2.  x1 > x2 < x3 > x4 < x5. . . . . and so, for
 *      Example :
 *          Input : arr = [1, 17, 5, 10, 13, 15, 10, 5, 16, 8]
 *          Output : 7
 *          Explanation: There are several subsequences that achieve this length.
 *                        One maximum length of good subsequences is [1, 17, 10, 13, 10, 16, 8].
 */

import java.util.Scanner;

public class POTD_Longest_Alternating_Subsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int[]arr = new int[sc.nextInt()];
        System.out.println("Elements :");
        for (int i = 0;i < arr.length;i++)
            arr[i] = sc.nextInt();
        System.out.println("One maximum length good subsequences is :");
        System.out.println(peaks(arr));
    }
    static int peaks(int[]arr){

        int increase = 1;
        int decrease = 1;

        for (int i = 1;i < arr.length;i++){
            if (arr[i] > arr[i-1])increase = decrease+1;
            if (arr[i] < arr[i-1])decrease = increase+1;
        }
        return Math.max(increase,decrease);
    }
}