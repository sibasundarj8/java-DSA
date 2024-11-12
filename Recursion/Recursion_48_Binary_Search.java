package Recursion;

import java.util.Scanner;

public class Recursion_48_Binary_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int[]arr = new int[sc.nextInt()];
        System.out.println("Elements(increasing order) :");
        for (int i = 0;i < arr.length;i++)
            arr[i] = sc.nextInt();
        System.out.println("Target :");
        int x = sc.nextInt();
        System.out.println("Index : " + find(arr,0,arr.length-1,x));
    }
    static int find (int[]arr,int start,int end,int target){
        // Base Case
        if(start > end)return -1;

        // Self Work
        int mid = start + (end-start)/2;
        if (arr[mid] == target)return mid;

        // Recursive Work
        else if (arr[mid] > target)
            return find(arr,start,mid-1,target);
        else return find(arr,mid+1,end,target);
    }
}
