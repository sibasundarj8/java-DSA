package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-number-in-one-swap1520/1
 *
 * # Largest number in one swap
 *
 *   Q. Given a string s, return the lexicographically largest string that can be obtained by swapping at most
 *      one pair of characters in s.
 *    Ex.
 *      Input : s = "768"
 *      Output: "867"
 *      Explanation: Swapping the 1st and 3rd characters(7 and 8 respectively), gives the lexicographically
 *                   largest string.
 */

import java.util.Scanner;
import java.util.TreeMap;

public class G03_Largest_number_in_one_swap {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String s = sc.next();

        System.out.println("Largest possible in one swap: " + largestSwap(s));
    }

    /// Solution
    static String largestSwap(String s) {
        // potd.code.hub
        int n = s.length();
        char[] chars = s.toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> b - a);

        // adding the right most position of each digit to treemap
        for (int i = n - 1; i >= 0; i--) {
            map.putIfAbsent(chars[i], i);
            if(map.size() == 10) break;
        }

        // checking for left-most smaller element as compare to the right-most largest element 
        for (int i = 0; i < n; i++) {
            char first = map.firstKey();

            if (first > chars[i]) {
                char c = chars[map.get(first)];
                chars[map.get(first)] = chars[i];
                chars[i] = c;
                return new String(chars);
            }

            if (map.get(first) <= i) map.remove(first);
        }

        return s;
    }
}
