package Recursion;
//  Return the Indices of target in an ArrayList

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_22_Array_linearSearch_Index_In_ArrayList
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Enter Your Target : ");
        int x = sc.nextInt();

        System.out.println(recLinear(arr,0,x));
    }
    static ArrayList<Integer> recLinear(int[]arr, int idx, int target)
    {
        // Self Work
        ArrayList<Integer>ans = new ArrayList<>();
        if (arr[idx] == target)ans.add(idx);

        // Base case
        if (idx == arr.length-1)return ans;

        // Recursive Work
        ans.addAll(recLinear(arr,idx+1,target));
        return ans;
    }
}