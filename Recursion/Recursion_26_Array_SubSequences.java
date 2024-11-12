package Recursion;/*
 *  Q.   Given an Array Of Integers, print sum of all subsets in it. Output sum can be
 *       printed in any order.
 *     Ex.-
 *        Input :- arr = {2, 4, 5};
 *        Output:- 11 6 7 2 9 4 5 0
 */
import java.util.Scanner;

public class Recursion_26_Array_SubSequences
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        recSubSequences(arr,arr.length,0,0);
    }
    static void recSubSequences(int[]arr,int n,int idx,int sum)
    {
        // Base Case
        if (idx >= n){
            System.out.print(sum + " ");
            return;
        }

        // Recursive Work
        recSubSequences(arr,n,idx+1,sum+arr[idx]);  // Include
        recSubSequences(arr,n,idx+1,sum);  // Exclude
    }
}