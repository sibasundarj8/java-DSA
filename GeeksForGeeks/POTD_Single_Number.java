package GFG;/*
 *
 *   Q. Given an array arr[] of positive integers where every element appears even times except for
 *      one. Find that number occurring an odd number of times.
 *   Examples:
 *      Input : arr[] = [1, 1, 2, 2, 2]
 *      Output: 2
 *      Explanation: In the given array all element appear two times except 2 which appears thrice.
 */
import java.util.Scanner;

public class POTD_Single_Number {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        System.out.println("Every elements must be appear even times except one..");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(getSingle(arr));
    }
    static int getSingle(int[]arr){
        // potd.code.hub
        int ans = 0;
        for (int i : arr) ans ^= i;
        return ans;
    }
}