package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_2_Sort_Descending_Order
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int x = sc.nextInt();

        ArrayList<String> s1 = new ArrayList<>();

        System.out.println("Enter String Value :");
        for(int i = 0; i < x; ++i)
        {
            s1.add(sc.next());
        }

        System.out.println("Original : " + s1);

        s1.sort(Collections.reverseOrder());

        System.out.println("Sorted : " + s1);
    }
}