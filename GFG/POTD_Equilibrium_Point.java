package GFG;

import java.util.Scanner;

public class POTD_Equilibrium_Point
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int n = sc.nextInt();

        long[]arr = new long[n];

        System.out.println("Enter Elements :");
        for (int i = 0;i < n;i++)
        {
            arr[i] = sc.nextInt();
        }
        System.out.println(equilibriumPoint(arr,n));
    }
    static int equilibriumPoint(long[]arr, int n) {

        // Your code here
        if (arr.length == 1)
        {
            return (int) arr[0];
        }
        if (arr.length == 2)
        {
            return -1;
        }
        long[]prefix = new long[n];
        prefix[0] = arr[0];
        long total = arr[0];

        for (int i = 1;i < n;i++)
        {
            total += arr[i];
            prefix[i] = total;
        }

        int ans = -1;

        for (int i = 1;i < n-1;i++)
        {
            if (prefix[i] == total-prefix[i+1])
            {
                ans = i+1;
            }
        }
        return ans;
    }
}
