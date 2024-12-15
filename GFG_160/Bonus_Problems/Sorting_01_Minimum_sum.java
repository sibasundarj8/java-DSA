package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-sum4058/0
 *
 * # Minimum sum
 *
 *   Q. Given an array arr[] such that each element is in the range [0 - 9], find the minimum possible
 *      sum of two numbers formed using the elements of the array. All digits in the given array must be
 *      used to form the two numbers. Return a string without leading zeroes.
 *    Ex.
 *      Input : arr[] = [6, 8, 4, 5, 2, 3]
 *      Output: 604
 *      Explanation: The minimum sum is formed by numbers 358 and 246.
 */
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_01_Minimum_sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i< n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(minSum(arr));
    }

    ///  Solution
    static String minSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        if (n == 1) return Integer.toString(arr[0]);

        Arrays.sort(arr);
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        StringBuilder ans = new StringBuilder();

        // finding minimum possible numbers
        for (int i = 0, j = 1; i < n; i += 2, j += 2) {
            num1.append(arr[i]);
            if (j < n) num2.append(arr[j]);
        }

        num1 = num1.reverse();
        num2 = num2.reverse();

        // adding two numbers
        int carry = 0;
        int i = 0;
        while (i < n/2){
            int d1 = num1.charAt(i) - '0';
            int d2 = num2.charAt(i) - '0';
            int temp = d1 + d2 + carry;
            if (temp < 10){
                carry = 0;
                ans.append(temp);
            }
            else {
                ans.append(temp % 10);
                carry = temp/10;
            }
            i++;
        }
        if (i < num1.length()) ans.append(carry + (num1.charAt(i) - '0'));
        else ans.append(carry);

        // removing leading Zeros
        for (i = ans.length()-1; i >= 0; i--){
            if (ans.charAt(i) != '0') break;
            ans.deleteCharAt(i);
        }

        return ans.reverse().toString();
    }
}
