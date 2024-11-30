package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/last-moment-before-all-ants-fall-out-of-a-plank/0
 *
 * # Last Moment Before All Ants Fall Out of a Plank
 *
 *   Q. We have a wooden plank of the length n units. Some ants are walking on the plank, each ant moves
 *      with a speed of 1 unit per second. Some of the ants move to the left, the other move to the right.
 *      When two ants moving in two different directions meet at some point, they change their directions
 *      and continue moving again. Assume changing directions does not take any additional time. When an
 *      ant reaches one end of the plank at a time t, it falls out of the plank immediately.
 *
 *      Given an integer n and two integer arrays left[] and right[], the positions of the ants moving to
 *      the left and the right, return the moment when the last ant(s) fall out of the plank.
 *    Ex.
 *      Input : n = 4
 *              left[] = [2]
 *              right[] = [0, 1, 3]
 *      Output: 4
 *      Explanation: As seen in the above image, the last ant falls off the plank at t = 4.
 */
public class Array_04_Last_Moment_Before_All_Ants_Fall_Out_of_a_Plank {

    /// main Method
    public static void main(String[] args) {
        int n = 4;
        int[]left = {2};
        int[]right = {0, 1, 3};

        System.out.println(getLastMoment(n, left, right));
    }

    /// Solution
    static int getLastMoment(int n, int[]left, int[]right) {
        // potd.code.hub
        int m1 = left.length;
        int m2 = right.length;
        int ans = 0;

        for (int i = 0;i < m1 || i < m2;i++){
            int t1 = 0;
            int t2 = 0;
            if (i < m1) t1 = left[i];
            if (i < m2) t2 = n - right[i];
            ans = Math.max(ans, Math.max(t1, t2));
        }
        return ans;
    }
}
