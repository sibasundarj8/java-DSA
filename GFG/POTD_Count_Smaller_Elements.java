package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class POTD_Count_Smaller_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();
        for (int i : nextSmaller(arr))
            System.out.print(i + " ");
    }
    static int[]nextSmaller(int[]arr){
        int n = arr.length;
        ArrayList<Integer>temp = new ArrayList<>();
        for (int i : arr)temp.add(i);
        Collections.sort(temp);
        for (int i = 0;i < n;i++){
            int t = binarySearch(temp,arr[i]);
            arr[i] = t;
            temp.remove(t);
        }
        return arr;
    }
    static int binarySearch(ArrayList<Integer>arr, int target){
        int start = 0;
        int end = arr.size();
        int ans = -1;
        while (start <= end){
            int mid = start + (end-start)/2;
            if (arr.get(mid) >= target){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
}