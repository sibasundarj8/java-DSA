package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/remove-the-balls--170647/1
 *
 * # Remove the balls
 *
 *   Q. You are given two arrays, color and radius, representing a sequence of balls:
 *
 *      -> color[i] is the color of the i-th ball.
 *      -> radius[i] is the radius of the i-th ball.
 *
 *      If two consecutive balls have the same color and radius, remove them both. Repeat this process until no
 *      more such pairs exist.
 *
 *      Return the number of balls remaining after all possible removals.
 *   Ex.
 *      Input : color[] = [2, 2, 5]
 *              radius[] = [3, 3, 5]
 *      Output: 1
 *      Explanation: First ball and second ball have same color 2 and same radius 3. So, after removing only one
 *                   ball is left. It cannot be removed from the array. Hence, the final array has length 1.
 */
import java.util.Scanner;
import java.util.Stack;

public class S7_Remove_the_balls {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter colors: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] color = new int[n];
        int[] radius = new int[n];

        for (int i = 0;i < n;i++){
            color[i] = Integer.parseInt(s[i]);
            radius[i] = sc.nextInt();
        }

        System.out.println("Remaining balls after removal: " + findLength(color, radius));
    }

    /// Solution
    static int findLength(int[] color, int[] radius) {
        // code here
        int n = color.length;
        Stack<String> st = new Stack<>();

        for (int i = 0;i < n;i++) {
            String s = color[i] + "" + radius[i];
            if (!st.isEmpty() && st.peek().equals(s)){
                st.pop();
            }
            else {
                st.push(s);
            }
        }

        return st.size();
    }
}
