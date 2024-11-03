package ArrayLists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_1_Reverse_List {
    public ArrayList_1_Reverse_List() {
    }

    static ArrayList<Integer> reverseList(ArrayList<Integer> l1) {
        int i = 0;

        for(int j = l1.size() - 1; i < j; --j) {
            Integer temp = l1.get(i);
            l1.set(i, l1.get(j));
            l1.set(j, temp);
            ++i;
        }

        return l1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> l1 = new ArrayList<>();
        System.out.println("Enter size :");
        int x = sc.nextInt();

        for(int i = 0; i < x; ++i) {
            l1.add(sc.nextInt());
        }

        System.out.println("Reverse using a loop..");
        System.out.println(reverseList(l1));
        Collections.reverse(l1);
        System.out.println("Reverse using Collection class..");
        System.out.println(l1);
    }
}