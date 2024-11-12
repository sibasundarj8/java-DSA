package Binary_Search;

import java.util.Scanner;

public class Searching_Binary_Search {
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
    static int find(int[]arr,int start,int end,int target){
        int result = -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr[mid] == target) {
                result = mid;
                break;
            } else if (target > arr[mid])start = mid+1;
            else end = mid-1;
        }
        return result;
    }
}
