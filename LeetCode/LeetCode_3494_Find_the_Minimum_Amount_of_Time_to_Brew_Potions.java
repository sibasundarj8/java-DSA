package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/
 *
 * # 3494. Find the Minimum Amount of Time to Brew Potions
 *
 *   Q. You are given two integer arrays, skill and mana, of length n and m, respectively.
 *
 *      In a laboratory, n wizards must brew m potions in order. Each potion has a mana capacity mana[j] and
 *      must pass through all the wizards sequentially to be brewed properly. The time taken by the ith wizard
 *       on the jth potion is timeɪj̱ = skill[i] * mana[j].
 *
 *      Since the brewing process is delicate, a potion must be passed to the next wizard immediately after
 *      the current wizard completes their work. This means the timing must be synchronized so that each wizard
 *      begins working on a potion exactly when it arrives.
 *
 *      Return the minimum amount of time required for the potions to be brewed properly.
 *   Ex.
 *      Input : skill = [1,5,2,4]
 *              mana = [5,1,4,2]
 *      Output: 110
 *      Explanation:        skill[]   =           1            5            2           4
 *                      +--------+-----------+-----------+-----------+-----------+-------------+
 *                      | Potion |    Start  | Wizard 0  |  Wizard 1 |	 Wizard 2 |	 Wizard 3  |    mana[]
 *                      | Number |    time   |  done by  |  done by  |  done by   |   done by  |     ||
 *                      +--------+-----------+-----------+-----------+------------+------------+
 *                      |   0    | 	    0    |     5	   |     30	   |    40	    |     60     |     5
 *                      +--------+-----------+-----------+-----------+------------+------------+
 *                      |   1    | 	   52    |     53	   |     58	   |    60	    |     64     |     1
 *                      +--------+-----------+-----------+-----------+------------+------------+
 *                      |   2    | 	   54	   |     58	   |     78	   |    86	    |     102    |     4
 *                      +--------+-----------+-----------+-----------+------------+------------+
 *                      |   3    | 	   86	   |     88	   |     98    |    102	    |     110    |     2
 *                      +--------+-----------+-----------+-----------+------------+------------+
 *
 *             As an example for why wizard 0 cannot start working on the 1st potion before time t = 52, consider
 *             the case where the wizards started preparing the 1st potion at time t = 50. At time t = 58, wizard
 *             2 is done with the 1st potion, but wizard 3 will still be working on the 0th potion till time t = 60.
 *
 *  Constraints:
 *        n == skill.length
 *        m == mana.length
 *        1 <= n, m <= 5000
 *        1 <= mana[i], skill[i] <= 5000
 */

import java.util.Scanner;

public class LeetCode_3494_Find_the_Minimum_Amount_of_Time_to_Brew_Potions {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("size of skills: ");
        int n = sc.nextInt();

        int[] skills = new int[n];

        System.out.println("Enter skills: ");
        for (int i = 0; i < n; i++) skills[i] = sc.nextInt();

        System.out.println("size of mana: ");
        int m = sc.nextInt();

        int[] mana = new int[m];

        System.out.println("Enter mana: ");
        for (int i = 0; i < m; i++) mana[i] = sc.nextInt();

        System.out.println("Minimum time time required for the potions to be brewed properly: ");
        System.out.println(minTime(skills, mana));
    }

    /// Solution
    static long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long startTime = 0; // starting time of a work

        int[] skillsPS = new int[n];

        skillsPS[0] = skill[0]; // calculating the prefix sum of skills array.
        for (int i = 1; i < n; i++) skillsPS[i] = skill[i] + skillsPS[i - 1];

        for (int task = 1; task < m; task++) {
            long currTime = startTime + (long) skill[0] * mana[task - 1];
            
            for (int worker = 0; worker < n; worker++) {
                long workerFree = startTime + (long) skillsPS[worker] * mana[task - 1];
                currTime = Math.max(currTime, workerFree) + (long) skill[worker] * mana[task];
            }
            
            startTime = currTime - (long) mana[task] * skillsPS[n - 1];
        }

        return startTime + (long) mana[m - 1] * skillsPS[n - 1];
    }
}
