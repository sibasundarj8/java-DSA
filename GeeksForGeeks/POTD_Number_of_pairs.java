package GFG;/*
 *       Q. Given two positive integer arrays arr and brr, find the number of pairs such that
 *          x^y > y^x (raised to power of) where x is an element from arr and y is an element from brr.
 *      Examples :
 *              Input: arr[] = [2 3 4 5],
 *                     brr[] = [1 2 3]
 *              Output: 5
 *              Explanation: The pairs which follow x^y > y^x are:
 *                           21 > 12, 31 > 13, 32 > 23, 41 > 14, 51 > 15 .
 */
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Number_of_pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("X size : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements : ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Y size : ");
        int m = sc.nextInt();
        int[]brr = new int[m];
        System.out.println("Elements : ");
        for (int i = 0;i < m;i++)
            brr[i] = sc.nextInt();

        System.out.println("Output :");
        System.out.println(countPairs(arr, brr, m));
    }
    static long countPairs(int[]x, int[]y, int n) {
        // potd.code.hub
        int n1 = 0, n2 = 0, n34 = 0;
        long ans = 0;
        Arrays.sort(x);
        Arrays.sort(y);
        for(int i : y){
            if (i > 4)break;
            if (i == 1) n1++;
            if (i == 2) n2++;
            if (i==3 || i==4) n34++;
        }
        for (int i : x){
            if (i != 1){
                ans += n1;
                if (i == 2) ans -= n34;
                if (i == 3) ans += n2;
                ans += n-1-find(y,n,i);
            }
        }
        return ans;
    }
    static long find(int[]arr, int n, int k){
        int l = 0, r = n-1, ans = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (arr[mid] <= k) {
                ans = mid;
                l = mid + 1;
            }
            else r = mid-1;
        }
        return ans;
    }
}