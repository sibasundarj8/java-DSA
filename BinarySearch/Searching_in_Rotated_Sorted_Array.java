package Binary_Search;

import java.util.Scanner;

public class Searching_in_Rotated_Sorted_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Target :");
        int target = sc.nextInt();
        System.out.println(find(arr,target));
    }
    static int find(int[]arr,int target){
        int n = arr.length;
        int st = 0;
        int end = n-1;
        while (st <= end){
            int mid = st + (end-st)/2;
            if (arr[mid] == target)return mid;
            else if (arr[st] == arr[mid] && arr[mid] == arr[end]){
                st++;
                end--;
            }
            else if (arr[mid] < arr[end]){
                if (target > arr[mid] && target <= arr[end])
                    st = mid+1;
                else end = mid-1;
            }
            else {
                if (target < arr[mid] && target >= arr[st])
                    end = mid-1;
                else st = mid+1;
            }
        }
        return -1;
    }
}