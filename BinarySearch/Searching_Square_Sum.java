package Binary_Search;/*
 *   Q. Given a non-negative integer c, decide whether there are two integers a and b
 *      such that a² + b² = c
 *    Ex.
 *      Input : 5
 *      Output : true
 */
import java.util.Scanner;

public class Searching_Square_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number : ");
        int n =sc.nextInt();
        System.out.println(test(n));
    }
    static boolean test(int n){
        for (int i = 0;i*i <= n;i++){
            int b = n - i*i;
            if (binarySearch(0,b,b))
                return true;
        }
        return false;
    }
    static boolean binarySearch(int l,int r,int n){
        // Base Case
        if (l > r)return false;

        // Recursive Work
        int mid = l + (r-l)/2;
        if (mid*mid == n)return true;
        if (mid*mid > n)
            return binarySearch(l,mid-1,n);
        else return binarySearch(mid+1,r,n);
    }
}