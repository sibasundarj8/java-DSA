package GFG;

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Minimum_Sum {

    /// Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(minSum(arr));
    }

    /// Solution
    static String minSum(int[] arr) {
        // potd.code.hub
        Arrays.sort(arr);

        // Finding the Numbers
        StringBuilder a = new StringBuilder(), b = new StringBuilder(), ans = new StringBuilder();
        int i = 0;
        while (i < arr.length){
            if (i % 2 == 0){
                a.append(arr[i]);
            }
            else {
                b.append(arr[i]);
            }
            i++;
        }
        a.reverse();
        b.reverse();

        // Addition of two numbers
        i = 0;
        int j = 0, sum = 0;
        while (i < a.length()){
            int m = a.charAt(i) - '0';
            int n = 0;
            if (j < b.length()){
                n = b.charAt(j) - '0';
                j++;
            }
            sum += m+n;
            ans.append(sum%10);
            sum/=10;
            i++;
        }
        ans.append(sum);
        ans.reverse();
        while (!ans.isEmpty() && ans.charAt(0) == '0')ans.deleteCharAt(0);
        return ans.isEmpty() ? "0" : ans.toString();
    }
}
