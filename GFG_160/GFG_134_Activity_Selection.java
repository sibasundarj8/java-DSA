package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1
 *
 * # Activity Selection
 *
 *   Q. You are given a set of activities, each with a start time and a finish time, represented by
 *      the arrays start[] and finish[], respectively. A single person can perform only one activity
 *      at a time, meaning no two activities can overlap. Your task is to determine the maximum number
 *      of activities that a person can complete in a day.
 *   Ex.
 *      Input : start[] = [1, 3, 0, 5, 8, 5]
 *             finish[] = [2, 4, 6, 7, 9, 9]
 *      Output: 4
 *      Explanation: A person can perform at most four activities. The maximum set of activities that
 *                   can be executed is {0, 1, 3, 4}
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GFG_134_Activity_Selection {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Start time: ");
        String[]s1 = sc.nextLine().split(" ");

        System.out.println("End time: ");
        String[]s2 = sc.nextLine().split(" ");

        int n = s1.length;
        int[]start = new int[n];
        int[]end = new int[n];

        for (int i = 0;i < n;i++){
            start[i] = Integer.parseInt(s1[i]);
            end[i] = Integer.parseInt(s2[i]);
        }

        System.out.println(activitySelection(start, end));
    }

    /// Solution
    private static class Pair{
        int st, en;
        Pair(int st, int en){
            this.st = st;
            this.en = en;
        }
    }
    static int activitySelection(int[] start, int[] finish) {
        // potd.code.hub
        int n = start.length;
        List<Pair> list = new ArrayList<>();
        for (int i = 0;i < n;i++)
            list.add(new Pair(start[i], finish[i]));

        list.sort((a, b) -> Integer.compare(a.en, b.en));

        int count = 0, last = 0;
        for (int i = 0;i < n;i++){
            Pair p = list.get(i);
            if (p.st > last){
                count++;
                last = p.en;
            }
        }

        return count;
    }
}
