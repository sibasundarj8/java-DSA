package ArrayLists;

import java.util.ArrayList;

public class ArrayList_0_Introduction {
    public ArrayList_0_Introduction() {     
    } 

    public static void main(String[] args) {
        Integer j = 10;
        Float f = 4.5F;
        System.out.println(j); 
        System.out.println(f);
        ArrayList<Integer> l1 = new ArrayList();
        l1.add(4);
        l1.add(5);
        l1.add(9);
        l1.add(3);
        l1.add(6);
        System.out.println(l1.get(1));

        for (Integer i : l1) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println(l1);
        l1.add(1, 54);
        System.out.println(l1);
        l1.set(1, 69);
        System.out.println(l1);
        l1.remove(1);
        System.out.println(l1);
       // l1.remove(9);
        System.out.println(l1);
        boolean ans = l1.contains(6);
        System.out.println(ans);
        System.out.println(l1.contains(23));
        ArrayList l2 = new ArrayList();
        l2.add("IronMan");
        l2.add(23);
        l2.add(false);
        l2.add(4.6);
        System.out.println(l2);
    }
}

