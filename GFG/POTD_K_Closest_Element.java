package GFG;/*  K Closest elements
 *
 *  Given a sorted array of unique elements in increasing order, arr[] of n integers, and a value x.
 *  Find the K closest elements to x in arr[].
 *
 *  Keep the following points in mind:
 *      If x is present in the array, then it need not be considered.
 *      If two elements have the same difference as x, the greater element is prioritized.
 *      If sufficient elements are not present on the right side, take elements from the left and vice versa.
 */
import java.util.Scanner;

public class POTD_K_Closest_Element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println("Enter the number X = ");
        int x = sc.nextInt();

        System.out.println("Enter K :");
        int k = sc.nextInt();

        for (int i : printKClosest(arr,n,k,x)) System.out.print(i + " ");
    }
    static int index(int[]arr, int n,int x)
    {
        int i = 0;
        int j = n-1;
        int mid;

        if (x <= arr[0]) return 0;
        if (x >= arr[n-1])return n-1;

        while (i <= j){
            mid = (i+j)/2;
            if(arr[mid] == x)return mid;
            else if(x > arr[mid])i = mid+1;
            else j = mid-1;
        }
        return arr[i]-x > x-arr[j] ? j : i;
    }
    static int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        int[]ans = new int[k];

        int z = index(arr,n,x);

        int i = z-1;
        int j = (x == arr[z]) ? z+1 : z;
        int idx = 0;

        while (i >= 0 && j < n && idx < k)
        {
            if (Math.abs(arr[i]-x) < Math.abs(arr[j]-x))ans[idx++]=arr[i--];
            else ans[idx++]=arr[j++];
        }
        while (i >= 0 && idx < k)
        {
            ans[idx++] = arr[i--];
        }
        while (j < n && idx < k)
        {
            ans[idx++] = arr[j++];
        }
        return ans;
    }
}