package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/majority-vote/1
 *
 * # Majority Element II
 *
 *   Q. You are given an array of integer arr[] where each number represents a vote to a candidate.
 *      Return the candidates that have votes greater than one-third of the total votes, If there's
 *      not a majority vote, return an empty array.
 *
 *      Note: The answer should be returned in an increasing format.
 *
 *    Ex.
 *      Input : arr[] = [2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6]
 *      Output: arr[] = [5, 6]
 *      Explanation: 5 and 6 occur more n/3 times.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GFG_06_Majority_Element_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(findMajority(arr));
    }

    /// Solution
    static List<Integer> findMajority(int[]nums) {
        // potd.code.hub
        List<Integer> ans = new ArrayList<>();
        int f1 = 0;
        int f2 = 0;
        int e1 = -1;
        int e2 = -1;

        for (int x : nums) {
            if (f1 == 0 && x != e2) {
                e1 = x;
                f1 = 1;
            } else if (f2 == 0 && x != e1) {
                e2 = x;
                f2 = 1;
            } else if (x == e1) f1++;
            else if (x == e2) f2++;
            else {
                f1--;
                f2--;
            }
        }

        int mini = nums.length / 3;
        f1 = 0;
        f2 = 0;
        for (int i : nums){
            if (i == e1) f1++;
            else if (i == e2) f2++;
        }

        if (f1 > mini) ans.add(e1);
        if (f2 > mini) ans.add(e2);
        Collections.sort(ans);

        return ans;
    }
}
