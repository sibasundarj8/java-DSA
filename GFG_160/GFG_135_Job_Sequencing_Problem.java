package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
 *
 * # Job Sequencing Problem
 *
 *   Q. You are given two arrays: deadline[], and profit[], which represent a set of jobs, where each
 *      job is associated with a deadline, and a profit. Each job takes 1 unit of time to complete,
 *      and only one job can be scheduled at a time. You will earn the profit associated with a job
 *      only if it is completed by its deadline.
 *
 *      Your task is to find:
 *          ● The maximum number of jobs that can be completed within their deadlines.
 *          ● The total maximum profit earned by completing those jobs.
 *    Ex.
 *      Input : deadline[] = [3,  1,  2,  2]
 *              profit[] =   [50, 10, 20, 30]
 *      Output: [3, 100]
 *      Explanation: Job1, Job3 and Job4 can be completed with a maximum profit of 100 (50 + 20 + 30).
 */
import java.util.*;

public class GFG_135_Job_Sequencing_Problem {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Deadline: ");
        String[] d1 = sc.nextLine().split(" ");

        System.out.println("Enter Profit: ");
        String[] p1 = sc.nextLine().split(" ");

        int n = d1.length;
        if (n != p1.length) return;

        int[] p = new int[n], d = new int[n];
        for (int i = 0;i <n;i++){
            p[i] = Integer.parseInt(p1[i]);
            d[i] = Integer.parseInt(d1[i]);
        }

        System.out.println(jobSequencing(d, p));
    }

    /// Solution
    static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // potd.code.hub
        int n = profit.length;
        ArrayList<Integer> list = new ArrayList<>();

        Pair[] arr = new Pair[n];
        for (int i = 0;i < n;i++)
            arr[i] = new Pair(deadline[i], profit[i]);

        Arrays.sort(arr, Comparator.comparing(a->a.deadline));
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int maxP = 0;
        for (int i = 0;i < n;i++){
            Pair p = arr[i];
            if (p.deadline > q.size())
                q.offer(p.profit);
            else if (!q.isEmpty() && p.profit > q.peek()){
                q.poll();
                q.offer(p.profit);
            }
        }
        list.add(q.size());
        
        while (!q.isEmpty())maxP += q.poll();
        list.add(maxP);
        
        return list;

    }
    private static class Pair{
        int deadline, profit;
        Pair(int deadline, int profit){
            this.profit = profit;
            this.deadline = deadline;
        }
    }
}
