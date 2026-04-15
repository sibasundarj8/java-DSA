package Greedy;/*
 *
 * https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/
 *
 * # 2515. Shortest Distance to Target String in a Circular Array
 *
 *   Q. You are given a 0-indexed circular string array words and a string target. A circular array means that the array's end
 *      connects to the array's beginning.
 *
 *      Formally, the next element of words[i] is words[(i + 1) % n] and the previous element of words[i] is words[(i - 1 + n) % n],
 *      where n is the length of words.
 *
 *      Starting from startIndex, you can move to either the next word or the previous word with 1 step at a time.
 *
 *      Return the shortest distance needed to reach the string target. If the string target does not exist in words, return -1.
 *
 *    Ex.
 *      Input : words = ["hello","i","am","leetcode","hello"], target = "hello", startIndex = 1
 *      Output: 1
 *      Explanation: We start from index 1 and can reach "hello" by
 *              - moving 3 units to the right to reach index 4.
 *              - moving 2 units to the left to reach index 4.
 *              - moving 4 units to the right to reach index 0.
 *              - moving 1 unit to the left to reach index 0.
 *              The shortest distance to reach "hello" is 1.
 *
 *  Constraints:
 *          1 <= words.length <= 100
 *          1 <= words[i].length <= 100
 *          words[i] and target consist of only lowercase English letters.
 *          0 <= startIndex < words.length
 */

import java.util.Scanner;

public class G08_Shortest_Distance_to_Target_String_in_a_Circular_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words: ");
        String[] words = sc.nextLine().split(" ");

        System.out.print("Target: ");
        String target = sc.next();

        System.out.print("Start index: ");
        int start = sc.nextInt();

        System.out.println("shortest distance needed to reach target: ");
        System.out.println(closestTarget(words, target, start));
    }

    /// Solution
    static int closestTarget(String[] words, String target, int startIndex) {
        // potd.code.hub
        int n = words.length;

        for (int dist = 0; dist < n; dist++) {
            int left = (startIndex - dist + n) % n;
            int right = (startIndex + dist) % n;

            if (words[left].equals(target) || words[right].equals(target)) {
                return dist;
            }
        }

        return -1;
    }
}
