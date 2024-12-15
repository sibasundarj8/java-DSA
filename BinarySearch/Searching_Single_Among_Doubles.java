package Binary_Search; /*
 * https://www.geeksforgeeks.org/problems/element-appearing-once2552/1
 *
 * # Single Among Doubles
 *
 *   Q. You are given a sorted array consisting of only integers where every element appears
 *      exactly twice, except for one element which appears exactly once.
 *      Return the single element that appears only once
 *    Ex.
 *       Input : n = 9
 *               arr[] = {1, 1, 2, 2, 4, 4, 5, 8, 8}
 *       Output : 5
 */
import java.util.Scanner;

public class Searching_Single_Among_Doubles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(search(n, arr));
    }

    /// Solution
    static int search(int n, int[]arr) {
        // potd.code.hub
        int ans = -1;
        int i = 0, j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (mid%2 == 0) {
                if (mid < n-1 && arr[mid] == arr[mid+1]) i = mid+1;
                else {
                    ans = arr[mid];
                    j = mid-1;
                }
            }
            else {
                if (mid > 0 && arr[mid-1] == arr[mid]) i = mid+1;
                else j = mid-1;
            }
        }

        return ans;
    }
}
