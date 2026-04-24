package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/buildings-receiving-sunlight3032/1
 *
 * # Buildings with Sunlight
 *
 *   Q. Given the array arr[] of heights of certain buildings that lie adjacent to each other, Sunlight starts falling from
 *      the left side of the buildings. If there is a building of a certain height, all the buildings to the right side of
 *      it having lesser heights cannot see the sun.
 *
 *      Find the total number of buildings that receive sunlight.
 *
 *    Ex.
 *      Input : arr[] = [6, 2, 8, 4, 11, 13]
 *      Output: 4
 *      Explanation: Only the buildings with heights 6, 8, 11, and 13 receive sunlight; therefore, the output is 4.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Scanner;

public class Array_Buildings_with_Sunlight {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter heights: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] buildings = new int[n];
        for (int i = 0; i < n; i++) {
            buildings[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of buildings that receive sunlight : ");
        System.out.println(visibleBuildings(buildings));
    }

    /// Solution
    static int visibleBuildings(int[] arr) {
        // code here
        int count = 0;
        int max = Integer.MIN_VALUE;

        for (int i : arr) {
            if (i >= max) {
                count++;
                max = i;
            }
        }

        return count;
    }
}
