/*
 *   Q. Given an array of integers arr, sort the array according to the frequency of elements,
 *      i.e.,elements that have higher frequency came first. If the frequencies of two elements
 *      are the same, then the smaller number comes first.
 *
 *    Examples :
 *      Input: arr[] = [5, 5, 4, 6, 4]
 *      Output: [4, 4, 5, 5, 6]
 *      Explanation: The highest frequency here is 2. Both 5 and 4 have that frequency.
 *                  Now, since the frequencies are the same, the smaller element comes first.
 *                  So 4 4 comes first and then comes 5 5. Finally comes 6. The output is
 *                  4 4 5 5 6.
 */
package GFG;


import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class POTD_Sorting_Elements_of_an_Array_by_Frequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Array Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Sorting on the basis of Frequency :");
        System.out.println(sortByFreq(arr));
    }
    static ArrayList<Integer> sortByFreq(int[]arr) {
        // potd.code.hub
        int n = arr.length;
        Arrays.sort(arr);
        ArrayList<int[]>temp = new ArrayList<>();

        // Storing Frequency
        int idx = 0;
        for (int i = 0;i < n-1;i++) {
            int count = 1;
            while (i < n-1 && arr[i] == arr[i+1]){
                count++;
                i++;
            }
            if (i < n-1 && arr[i] != arr[i + 1]) {
                temp.add(new int[2]);
                temp.get(idx)[0] = arr[i];
                temp.get(idx)[1] = count;
                idx++;
            }
        }
        int i = n-1;
        int count  = 1;
        while (i >= 0 && arr[i] == arr[i-1]) {
            count++;
            i--;
        }
        temp.add(new int[2]);
        temp.get(idx)[0] = arr[n-1];
        temp.get(idx)[1] = count;

        temp.sort(Comparator.comparingInt((a) -> -a[1]));

        ArrayList<Integer>ans = new ArrayList<>();
        for (int[] x : temp)
            for (int j = 0;j < x[1];j++)
                ans.add(x[0]);
        return ans;
    }
}