package GFG;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Minimum_Platforms
{
    static int findPlatform(int[] arr, int[] dep, int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count = 0;
        int ans = 0;
        int i = 0;
        int j = 0;

        while(i < n)
        {
            if (arr[i] <= dep[j])
            {
                count++;
                ans = Math.max(ans, count);
                i++;
            } else if (arr[i] > dep[j])
            {
                count--;
                j++;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of trains :");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Arrival times of all trains :");
        arrayInput(arr);

        int[] dep = new int[n];

        System.out.println("Enter Departure of all trains :");
        arrayInput(dep);

        PrintStream var10000 = System.out;

        int var10001 = findPlatform(arr, dep, n);
        var10000.println("Minimum platform required : " + var10001);
    }

    static void arrayInput(int[] a)
    {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < a.length; ++i)
        {
            a[i] = sc.nextInt();
        }
    }
}