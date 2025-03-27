package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
 *
 * # Minimum Platforms
 *
 *   Q. You are given the arrival times arr[] and departure times dep[] of all trains that arrive at
 *      a railway station on the same day. Your task is to determine the minimum number of platforms
 *      required at the station to ensure that no train is kept waiting.
 *
 *      At any given time, the same platform cannot be used for both the arrival of one train and the
 *      departure of another. Therefore, when two trains arrive at the same time, or when one arrives
 *      before another departs, additional platforms are required to accommodate both trains.
 *   Ex.
 *      Input : arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
 *      Output: 3
 *      Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3
 *                   platforms.
 */
import java.util.*;

public class GFG_133_Minimum_Platforms {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of trains: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] dep = new int[n];

        System.out.println("Enter staring time and then ending time for each train: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
            dep[i] = sc.nextInt();
        }

        System.out.println(findPlatform(arr, dep));
    }

    /// Solution
    
/*************************************************************Use-Extra-space**************************************************************************/
/// Time complexity: O(n log n)
/// Space Complexity: O(n)
    /*static int findPlatform(int[] arr, int[] dep) {
        // potd.code.hub
        int n = arr.length, ans = 0, count = 0;

        List<Pair> temp = new LinkedList<>();
        for (int i = 0;i < n;i++){
            temp.add(new Pair(arr[i], 'a'));
            temp.add(new Pair(dep[i], 'd'));
        }

        temp.sort((o1, o2) -> {
            int x = o1.val - o2.val;
            if (x != 0)
                return x;
            else return Integer.compare(o1.type, o2.type);
        });

        n = temp.size();
        for (int i = 0;i < n;i++){
            if (temp.get(i).type == 'a')
                count++;
            else count--;
            ans = Math.max(ans, count);
        }

        return ans;
    }
    private static class Pair{
        int val;
        char type;
        Pair (int val, char type){
            this.val = val;
            this.type = type;
        }
    }*/

/****************************************************Space-Optimized_Using-two-pointer*******************************************************************/
/// Time Complexity: O(n log n)
/// Space Complexity: O(1)
    static int findPlatform(int[] arr, int[] dep) {
        // potd.code.hub
        int n = arr.length, ans = 0, count = 0;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0, j = 0;
        while (i < n){
            if (arr[i] <= dep[j]){
                count++;
                i++;
                ans = Math.max(ans, count);
            }
            else {
                count--;
                j++;
            }
        }

        return ans;
    }
}
