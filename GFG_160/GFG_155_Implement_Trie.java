package GFG_160;/* 
 *
 * https://www.geeksforgeeks.org/problems/trie-insert-and-search0651/1
 *
 * # Implement Trie
 *
 *   Q. Implement Trie class and complete insert(), search() and isPrefix() function for the
 *      following queries :
 *
 *      Type 1: (1, word), calls insert(word) function and insert word in the Trie
 *      Type 2: (2, word), calls search(word) function and check whether word exists in Trie or
 *              not.
 *      Type 3: (3, word), calls isPrefix(word) function and check whether a word exists as a
 *              prefix of any string in Trie or not.
 *   Ex.
 *      Input : query[][] = [[1, "abcd"],
 *                           [1, "abc"],
 *                           [1, "bcd"],
 *                           [2, "bc"],
 *                           [3, "bc"],
 *                           [2, "abc"]]
 *      Output: [false, true, true]
 *      Explanation: string "bc" does not exist in the trie, "bc" exists as prefix of the word
 *                   "bcd" in the trie, and "abc" also exists in the trie.
 */
import java.util.Scanner;

public class GFG_155_Implement_Trie {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Trie root = new Trie();
        System.out.println("Enter choice: ");
        while (sc.hasNext()){
            String choice = sc.next();
            System.out.println("Enter the word: ");
            String s = sc.next();
            switch (choice){
                case "1" -> root.insert(s);
                case "2" -> System.out.println(root.search(s));
                case "3" -> System.out.println(root.isPrefix(s));
                default -> {
                    return;
                }
            }
            System.out.println("Enter choice: ");
        }
    }
}
class Trie {

    private final Trie[] trie = new Trie[26];
    private boolean flag = false;

    public Trie() {
        // Implement Trie
    }

    // Insert a word into the Trie
    public void insert(String word) {
        Trie temp = this;
        int n = word.length();
        for (int i = 0;i < n;i++){
            int pos = word.charAt(i) - 'a';
            if (!temp.containsKey(pos)){
                temp.trie[pos] = new Trie();
            }
            temp = temp.trie[pos];
        }
        temp.flag = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Trie temp = this;
        int n = word.length();
        for (int i = 0;i < n;i++){
            int pos = word.charAt(i) - 'a';
            if (!temp.containsKey(pos)){
                return false;
            }
            temp = temp.trie[pos];
        }
        return temp.isEnd();
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        Trie temp = this;
        int n = word.length();
        for (int i = 0;i < n;i++){
            int pos = word.charAt(i) - 'a';
            if (!temp.containsKey(pos)){
                return false;
            }
            temp = temp.trie[pos];
        }
        return true;
    }

    
    private boolean containsKey (int pos){
        return trie[pos] != null;
    }
    private boolean isEnd (){
        return flag;
    }
}
