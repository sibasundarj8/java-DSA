/*
 *   Q.  There are N stones, Numbered 0,1,2,...,N-1. For each i(0 ≤ i < n), the height of stone i is hi.
 *       There is a frog eho is initially on stone 0. He will repeat the following action some number of
 *       times to reach the Stone N-1. If the frog is currently on stone i, jump to stone i+1 or i+2.
 *       Here, a cost of |hi - hj| if incurred, Where j is the stone to land on.
 *
 *       Find the minimum possible total cost incurred before the frog reaches Stone N.
 *
 *   Ex: -    Input:
 *                     n  =  4
 *                     arr[] = 10 30 40 20
 *
 *          Output:    30
 */
package Recursion;


import java.util.Scanner;

public class Recursion_41_Frog_Jump {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Array Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)arr[i]= sc.nextInt();

        System.out.println(minCost(arr,n,0));
    }
    static int minCost(int[]arr,int n,int idx){
        // Base Case
        if (idx == n-1)return 0;

        // Recursive Work
        int way1 = minCost(arr,n,idx+1) + Math.abs(arr[idx]-arr[idx+1]);
        if (idx == n-2)return way1;/*Base Case*/
        int way2 = minCost(arr,n,idx+2) + Math.abs(arr[idx]-arr[idx+2]);

        // Self-Work
        return Math.min(way1,way2);
    }
}