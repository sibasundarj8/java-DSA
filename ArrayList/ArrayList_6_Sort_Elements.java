package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_6_Sort_Elements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Elements :");
        for(int i = 0; i < n; ++i)
        {
            list.add(sc.nextInt());
        }

        Collections.sort(list);
        System.out.println(list);
    }
}