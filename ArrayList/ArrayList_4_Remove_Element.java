package ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayList_4_Remove_Element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Element :");
        for(int i = 0; i < n; ++i)
        {
            list.add(sc.nextInt());
        }
        list.remove(2);

        System.out.println("ArrayList is :");
        System.out.println(list);
    }
}