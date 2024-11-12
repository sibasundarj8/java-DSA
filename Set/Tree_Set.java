package Set;

import java.util.Set;
import java.util.TreeSet;

public class Tree_Set {     // O(logⁿ)
    public static void main(String[] args) {
        Set<Integer> s = new TreeSet<>();

        s.add(32);
        s.add(2);
        s.add(54);
        s.add(21);
        s.add(65);
      // [2, 21, 32, 54, 65]  (Always in sorted order)
        System.out.println(s);

        s.remove(54);
      // [2, 21, 32, 65]
        System.out.println(s);

        System.out.println(s.contains(65)); // true
        System.out.println(s.isEmpty());    // false

        s.clear();
        System.out.println(s);  // []
    }
}