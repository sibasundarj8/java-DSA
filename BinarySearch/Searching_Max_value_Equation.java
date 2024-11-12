package Binary_Search;

import java.util.Scanner;

public class Searching_Max_value_Equation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Value of A, B, C :");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c =sc.nextInt();
        System.out.println("K : ");
        int k = sc.nextInt();
        System.out.println(findMax(a,b,c,k));
    }
    static int findMax(int a,int b,int c, int k){
        if (function(a, b, c, 1) <= 0) return 0;
        int l = 0;
        int r = 1000000;
        int ans = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            if (function(a, b, c, mid) <= k){
                ans = mid;
                l = mid+1;
            }
            else r = mid-1;
        }
        return ans;
    }
    public static long function(int a, int b, int c, int x) {
        return (long) a * x * x + (long) b * x + c;
    }
}