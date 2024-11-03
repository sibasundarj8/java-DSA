package ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_3_Add_Element
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

        System.out.println("Insert Element :");
        list.add(0, sc.nextInt());

        System.out.println(list);
    }
}