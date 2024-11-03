package ArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist_7_EnterOnlyPositive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size of Array :");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Array Elements :");
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            if (arr[i] >= 0)
                list.add(arr[i]);
        if (list.isEmpty())
            System.out.println("NA");
        else System.out.println(list);
    }
}