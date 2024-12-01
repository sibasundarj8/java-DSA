package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class POTD_1st_and_Last_Occurrences_of_X
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Enter Elements :");
        for (int i = 0;i < n;i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the number :");
        int x = sc.nextInt();

        System.out.println(find(arr,n,x));
    }
    static ArrayList<Integer> find(int[]arr, int n, int x)
    {
        // code here
        ArrayList<Integer>list = new ArrayList<>();
        int i;
        int v = -1;
        for (i = 0;i < n;i++)
        {
            if (arr[i] == x)
            {
                list.add(i);
                break;
            }
        }
        for (int j = i;j < n;j++)
        {
            if (arr[j] == x)
            {
                v = j;
            }
        }
        list.add(v);

        if (list.size() == 1)
        {
            list.add(-1);
        }

        return list;
    }
}
