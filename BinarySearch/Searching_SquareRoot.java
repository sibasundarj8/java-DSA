package Binary_Search;

import java.util.Scanner;

public class Searching_SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number :");
        int n = sc.nextInt();
        System.out.println(findSquareRoot(n));
    }
    static int findSquareRoot(int n){
        int start = 0;
        int end = n;
        int ans = 0;
        while(start <= end){
            int mid = start + (end-start)/2;
            long t = (long) mid*mid;
            if (n == t)return mid;
            else if (t>n)end = mid-1;
            else {
                start = mid+1;
                ans = mid;
            }
        }
        return ans;
    }
}