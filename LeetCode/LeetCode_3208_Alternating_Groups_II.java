package LeetCode;/*
 *
 * https://leetcode.com/problems/alternating-groups-ii/
 *
 * #3208. Alternating Groups II
 *
 *   Q. There is a circle of red and blue tiles. You are given an array of integer's colors and an integer
 *      k. The color of tile i is represented by colors[i]:
 *
 *       • colors[i] == 0 means that tile i is red.
 *       • colors[i] == 1 means that tile i is blue.
 *
 *      An alternating group is every k contiguous tiles in the circle with alternating colors (each tile
 *      in the group except the first and last one has a different color from its left and right tiles).
 *
 *      Return the number of alternating groups.
 *
 *      Note that since colors represent a circle, the first and the last tiles are considered to be next
 *      to each other.
 *    Ex.
 *      Input : colors = [0,1,0,1,0]
 *              k = 3
 *      Output: 3
 *      Explanation: Three groups are: [0 -> 2] {0, 1, 0}
 *                                     [1 -> 3] {1, 0, 1}
 *                                     [2 -> 4] {0, 1, 0}
 *                   which contains alternate colors with size k.
 */
import java.util.Scanner;

public class LeetCode_3208_Alternating_Groups_II {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] colors = new int[n];

        System.out.println("""
                            Elements:\s
                              0 -> red
                              1 -> blue""");
        for (int i = 0;i < n;i++)
            colors[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(numberOfAlternatingGroups(colors, k));
    }

    /// Solution
    static int numberOfAlternatingGroups(int[] colors, int k) {
        // @ sibasundarj8@gmail.com
        int n = colors.length;
        int count = 0, size = 1, firstCount = 0, lastCount;

        for (int i = 1;i < n;i++){
            if (colors[i] != colors[(i-1)]){
                size ++;
                if (size >= k) count++;
            }
            else {
                if (firstCount == 0)
                    firstCount = Math.min(size, k-1);
                size = 1;
            }
        }
        if (firstCount == 0) firstCount = k-1;
        lastCount = Math.min(size, k-1);

        if (colors[0] != colors[n-1] && firstCount+lastCount >= k)
            count += firstCount+lastCount - (k-1);

        return count;
    }
}
