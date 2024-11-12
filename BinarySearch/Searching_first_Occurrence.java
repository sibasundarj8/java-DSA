package Binary_Search;

import java.util.Scanner;

public class Searching_first_Occurrence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int[]arr = new int[sc.nextInt()];
        System.out.println("Elements(Increasing Order) :");
        for (int i = 0;i < arr.length;i++)
            arr[i] = sc.nextInt();
        System.out.println("Target :");
        int x = sc.nextInt();
        System.out.println("First Occurrence of " + x + " at :");
        System.out.println(find(arr,x));
    }
    static int find(int[]arr,int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int fi = -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target){
                fi = mid;
                end = mid-1;
            }
            else if (arr[mid] > target)end = mid-1;
            else start = mid+1;
        }
        return fi;
    }
}