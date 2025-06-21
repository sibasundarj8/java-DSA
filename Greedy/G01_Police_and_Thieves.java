package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
 *
 * # Police and Thieves
 *
 *   Q. Given an array arr[], where each element contains either a 'P' for policeman or a 'T' for thief. Find the
 *      maximum number of thieves that can be caught by the police.
 *
 *      Keep in mind the following conditions :
 *        ➕ Each policeman can catch only one thief.
 *        ➕ A policeman cannot catch a thief who is more than k units away from him.
 *    Ex.
 *      Input : arr[] = ['T', 'T', 'P', 'P', 'T', 'P']
 *              k = 2
 *      Output: 3
 *      Explanation: Maximum 3 thieves can be caught.
 */

import java.util.Scanner;

public class G01_Police_and_Thieves {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements('T' for thief and 'P' for police): ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        char[] arr = new char[n];

        for (int i = 0;i < n;i++)
            arr[i] = s[i].charAt(0);

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Max thief caught: " + catchThieves(arr, k));
    }

    /// Solution
    static int catchThieves(char[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        // greedy -> the earliest matched pair leads to the optimal solution
        // two pointer approach
        int thief = 0, police = 0;
        while (thief < n && police < n) {

            // finding the earliest thief
            while (thief < n && arr[thief] != 'T') {
                thief++;
            }

            // finding the earliest police
            while (police < n && arr[police] != 'P') {
                police++;
            }

            // making decision on the basis of distance
            int dist = Math.abs(police - thief);
            if (dist <= k && police < n && thief < n) {
                ans++;
                police++;
                thief++;
            } else if (police < thief) police++;
            else thief++;
        }

        return ans;
    }
}
