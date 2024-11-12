package Set;

import java.util.LinkedHashSet;
import java.util.Set;

public class Linked_HasSet {
    public static void main(String[] args) {
        Set<Integer> s = new LinkedHashSet<>();

        s.add(32);
        s.add(2);
        s.add(54);
        s.add(21);
        s.add(65);
      // [32, 2, 54, 21, 65]  (It maintains the insertion order)
        System.out.println(s);

        s.remove(54);
      // [32, 2, 21, 65]
        System.out.println(s);

        System.out.println(s.contains(65)); // true
        System.out.println(s.isEmpty());    // false

        s.clear();
        System.out.println(s);  // []
    }
}