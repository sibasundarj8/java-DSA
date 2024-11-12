package Binary_Search;

import java.util.Scanner;

public class Searching_k_Closest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size : ");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements : ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        System.out.println("Target :");
        int t = sc.nextInt();
        System.out.println("K :");
        int k = sc.nextInt();

    }
//    static ArrayList<Integer> find(int[]arr,int k,int target){
//        ArrayList<Integer>ans = new ArrayList<>();
//        int i = binarySearch(arr,target);
//        int j = i;
//        int count = 0;
//        while (count < k){
//
//            count++;
//        }
//
//    }
    static int binarySearch(int[]arr,int target){
        int l = 0;
        int r = arr.length-1;
        int ans = -1;
        while (l >= r){
            int mid = l + (r-l)/2;
            if (arr[mid] == target){
                ans = mid;
                r = mid-1;
            }
            else if (arr[mid] > target)
                r = mid-1;
            else l = mid+1;
        }
        return ans;
    }
}
