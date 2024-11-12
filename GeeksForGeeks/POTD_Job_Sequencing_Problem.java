package GFG;/*
 *   Q. Given a set of n jobs where each jobi has a deadline and profit associated with it.
 *      Each job takes 1 unit of time to complete and only one job can be scheduled at a time.
 *      We earn the profit associated with a job if and only if the job is completed by its
 *      deadline.
 *      Find the number of jobs done and the maximum profit.
 *      Note: Jobs will be given in the form (JobId, Deadline, Profit) associated with that Job.
 *            Deadline of the job is the time on or before which job needs to be completed to
 *            earn the profit.
 *      Examples :
 *                  Input: Jobs = [[1,4,20],
 *                                  [2,1,1],
 *                                  [3,1,40],
 *                                  [4,1,30]]
 *                  Output:  2  60
 *                  Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
 */
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Job_Sequencing_Problem {
    static class Job {
        int id, deadline, profit ;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of Jobs :");
        int n = sc.nextInt();
        Job[]arr = new Job[n];
        for (int i = 0;i < n;i++){
            //System.out.println("Job Details(id,deadLine,profit) :");
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            arr[i] = new Job(x,y,z);
        }
        for (int i : JobScheduling(arr,n))
            if (i != 0)
                System.out.println(i);
    }
    static int[] JobScheduling(Job[]arr, int n)
    {
        // potd.code.hub
        int total = 0;
        int noj = 0;
        boolean[]slot = new boolean[n];
        Arrays.sort(arr, (o1,o2) -> Integer.compare(o2.profit,o1.profit));
        for (int i = 0;i < n;i++){
            for (int j = arr[i].deadline-1;j >= 0;j--){
                if (!slot[j]){
                    total += arr[i].profit;
                    noj++;
                    slot[j] = true;
                    break;
                }
            }
        }
        return new int[]{noj, total};
    }
}