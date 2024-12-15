package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/largest-number-formed-from-an-array1117/1
 *
 * # Form the Largest Number
 *
 *   Q. Given an array of integers arr[] representing non-negative integers, arrange them so that after
 *      concatenating all of them in order, it results in the largest possible number. Since the result
 *      may be very large, return it as a string.
 *    Ex.
 *      Input : arr[] = [3, 30, 34, 5, 9]
 *      Output: "9534330"
 *      Explanation: Given numbers are [3, 30, 34, 5, 9], the arrangement "9534330" gives the largest
 *                   value.
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Sorting_03_Form_the_Largest_Number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findLargest(arr));
    }

    /// Solution
    static String findLargest(int[] arr) {
        // potd.code.hub
        String[] strArr = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[] ::new);
        Comparator<String>comparator = (a, b) -> {
            String ab = a + b;
            String ba = b + a;
            return ba.compareTo(ab);
        };
        Arrays.sort(strArr, comparator);
        if (strArr[0].equals("0")) return "0";

        StringBuilder ans = new StringBuilder();
        for (String num : strArr) ans.append(num);

        return ans.toString();
    }
}
