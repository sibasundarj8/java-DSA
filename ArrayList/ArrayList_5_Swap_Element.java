package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_5_Swap_Element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Element :");
        int x;
        for(x = 0; x < n; ++x)
        {
            list.add(sc.nextInt());
        }

        System.out.println("Enter the indices to swap Elements :");
        x = sc.nextInt();

        int y = sc.nextInt();

        Collections.swap(list, x, y);

        System.out.println(list);
    }
}