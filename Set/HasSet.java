package Set;

import java.util.HashSet;
import java.util.Set;

public class HasSet {   // O(1)
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();

        s.add(32);
        s.add(2);
        s.add(54);
        s.add(21);
        s.add(65);
      // [32, 65, 2, 21, 54]  (it doesn't care about insertion order)
        System.out.println(s);

        s.remove(54);
      // [32, 65, 2, 21]
        System.out.println(s);

        System.out.println(s.contains(65)); // true
        System.out.println(s.isEmpty());    // false

        s.clear();
        System.out.println(s);  // []
    }
}
