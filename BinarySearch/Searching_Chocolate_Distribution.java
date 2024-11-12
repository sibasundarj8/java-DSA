package Binary_Search;/*
 *   Q. You have 'n'(n <= 10⁵) boxes of chocolate. Each box contains a[i],(a[i] <= 10000) chocolates.
 *      You need to distribute these boxes among 'm' students such that the maximum number of chocolates
 *      allocated to a student is minimum.
 *       ● One box will be allocated to exactly one student.
 *       ● All the boxes should be allocated.
 *       ● Each student has to be allocated at least one box.
 *       ● Allotment should be in contiguous order,
 *         for instance, a student cannot be allocated box I and box 3, skipping box 2.
 *    Ex.
 *       Input : n = 4
 *               arr[] = {12, 34, 67, 90}
 *               m = 2
 *
 *       Output : 113
 */
import java.util.Scanner;

public class Searching_Chocolate_Distribution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Boxes :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Number of Chocolates :");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Number of Students :");
        int s = sc.nextInt();

        System.out.println("Output :\n" + distributeChocolate(arr,s));
    }
    static int distributeChocolate(int[]arr,int students){
        int n = arr.length;
        int l = 1, r = (int) 10e9;
        int ans = 0;

        if (n < students)return -1;

        while (l <= r){
            int mid = l + (r-l)/2;
            if (isPossible(arr,students,mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid+1;
        }
        return ans;
    }
    static boolean isPossible(int[]arr,int students,int max){
        int nos = 1; // number of Students
        int cho = 0; // number of chocolates has been distributed

        for (int i : arr) {
            if (i > max) return false;
            if (cho + i <= max)
                cho += i;
            else {
                nos++;
                cho = i;
            }
        }
        return nos <= students;
    }
}