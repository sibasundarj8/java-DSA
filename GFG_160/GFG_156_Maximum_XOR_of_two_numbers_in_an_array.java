package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-xor-of-two-numbers-in-an-array/1
 *
 * # Maximum XOR of two numbers in an array
 *
 *   Q. Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR
 *      between two numbers present in the array.
 *   Ex.
 *      Input : arr[] = [25, 10, 2, 8, 5, 3]
 *      Output: 28
 *      Explanation: The maximum possible XOR is 5 ^ 25 = 28.
 */

import java.util.Scanner;

public class GFG_156_Maximum_XOR_of_two_numbers_in_an_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: ");
        String[] s = sc.nextLine().split(" ");

        int[] arr = new int[s.length];
        for (int i = 0; i < s.length; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println(maxXor(arr));
    }

    /**********************************************************Solution******************************************************/

    /// Structure
    private static class Trie {
        private final Trie[] link;

        // Constructor
        Trie() {
            link = new Trie[2];
        }

        // Insert into Trie
        void insert(int n) {
            Trie temp = this;
            for (int i = 31; i >= 0; i--) {
                int pos = (n >> i) & 1;
                temp = temp.getLink(pos);
            }
        }

        // Get Max XOR from each element
        int getMaxXor(int n) {
            Trie temp = this;
            int max = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (n >> i) & 1;
                if (temp.containsKey(1 - bit)) {
                    max |= (1 << i);
                    temp = temp.getLink(1 - bit);
                } else 
                    temp = temp.getLink(bit);
            }
            return max;
        }

        private boolean containsKey(int bit) {
            return this.link[bit] != null;
        }

        private Trie getLink(int bit) {
            if (!this.containsKey(bit)) 
                this.link[bit] = new Trie();
            return this.link[bit];
        }
    }

    static int maxXor(int[] arr) {
        // potd.code.hub
        Trie trie = new Trie();

        for (int i : arr) 
            trie.insert(i);

        int ans = 0;
        for (int i : arr) 
            ans = Math.max(ans, trie.getMaxXor(i));

        return ans;
    }
}
