package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1
 *
 * # Count the number of possible triangles
 *
 *   Q. Given an integer array arr[]. Find the number of triangles that can be formed with three different array
 *      elements as lengths of three sides of the triangle.
 *
 *      A triangle with three given sides is only possible if sum of any two sides is always greater than the
 *      third side.
 *    Ex.
 *      Input : arr[] = [4, 6, 3, 7]
 *      Output: 3
 *      Explanation: There are three triangles possible [3, 4, 6], [4, 6, 7] and [3, 6, 7].
 *                   Note that [3, 4, 7] is not a possible triangle.
 */
import java.util.Arrays;
import java.util.Scanner;

public class GFG_55_Count_the_number_of_possible_triangles {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println(countTriangles(arr));
    }

    /// Solution
    static int countTriangles(int...arr) {
        // potd.code.hub
        Arrays.sort(arr);
        int n = arr.length-1;
        int count = 0;

        for (int i = n;i >= 0;i--){
            int l = 0, r = i-1;
            while (l < r)
                if (arr[l]+arr[r] > arr[i]) count += r---l;
                else l++;
        }

        return count;
    }
}
