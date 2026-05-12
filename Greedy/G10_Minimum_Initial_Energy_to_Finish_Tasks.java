package Greedy;/*
 *
 * https://leetcode.com/problems/minimum-initial-energy-to-finish-tasks/
 *
 * # 1665. Minimum Initial Energy to Finish Tasks
 *
 *   Q. You are given an array tasks where tasks[i] = [actual-i, minimum-i]:
 *        ◦ actual-i is the actual amount of energy you spend to finish the ith task.
 *        ◦ minimum-i is the minimum amount of energy you require to begin the ith task.
 *
 *      For example, if the task is [10, 12] and your current energy is 11, you cannot start this task. However, if your
 *      current energy is 13, you can complete this task, and your energy will be 3 after finishing it.
 *
 *      You can finish the tasks in any order you like.
 *
 *      Return the minimum initial amount of energy you will need to finish all the tasks.
 *
 *    Ex.
 *      Input: tasks = [[1,3],[2,4],[10,11],[10,12],[8,9]]
 *      Output: 32
 *      Explanation:
 *              Starting with 32 energy, we finish the tasks in the following order:
 *                  - 1st task. Now energy = 32 - 1 = 31.
 *                  - 2nd task. Now energy = 31 - 2 = 29.
 *                  - 3rd task. Now energy = 29 - 10 = 19.
 *                  - 4th task. Now energy = 19 - 10 = 9.
 *                  - 5th task. Now energy = 9 - 8 = 1.
 *
 *  Constraints:
 *          1 <= tasks.length <= 10⁵
 *          1 <= actual-i <= minimum-i <= 10⁴
 */

import java.util.Arrays;
import java.util.Scanner;

public class G10_Minimum_Initial_Energy_to_Finish_Tasks {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number of Tasks: ");
        int n = sc.nextInt();
        int[][] tasks = new int[n][2];

        System.out.println("Enter tasks: (actual_time, minimum_time)");
        for (int i = 0; i < n; i++) {
            tasks[i][0] = sc.nextInt();
            tasks[i][1] = sc.nextInt();
        }

        System.out.println("Minimum initial amount of energy required to finish all the tasks: ");
        System.out.println(minimumEffort(tasks));
    }

    /// Solution
    static int minimumEffort(int[][] tasks) {
        // potd.code.hub
        int required = 0;
        int curr = 0;

        Arrays.sort(tasks, (a, b) -> {
            int difA = a[1] - a[0];
            int difB = b[1] - b[0];

            return (difA == difB) ? b[1] - a[1] : difB - difA;
        });

        for (int[] task : tasks) {
            if (task[1] > curr) {
                required += (task[1] - curr);
                curr = task[1];
            }

            curr -= task[0];
        }

        return required;
    }
}
