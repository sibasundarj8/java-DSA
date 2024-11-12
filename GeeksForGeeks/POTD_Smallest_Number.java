package GFG;/*
 *    Q. Given two integers s and d. The task is to find the smallest number
 *       such that the sum of its digits is s and the number of digits in the
 *       number are d. Return a string that is the smallest possible number.
 *       If it is not possible then return -1.
 *
 *      Examples:
 *          Input: s = 9, d = 2
 *          Output: 18
 *          Explanation:
 *               18 is the smallest number possible with the sum of digits = 9
 *               and total digits = 2.
 */
import java.util.Scanner;

public class POTD_Smallest_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of digits :");
        int d = sc.nextInt();
        System.out.println("Sum of digits :");
        int s = sc.nextInt();
        System.out.println("Generating smallest number...\n.");
        System.out.println(smallestNumber(s,d));
    }
    static String smallestNumber(int s, int d){
        // Base Case
        if (d*9 < s)return "-1";

        String ans = "";
        for (int i = d-1;i >= 0;i--){
            if (s > 9){
                ans += '9';
                s -= 9;
            }
            else {
                if (i == 0)ans = s + ans;
                else {
                    ans = s-1 + ans;
                    while(i > 0){
                        ans = '0' + ans;
                        i--;
                    }
                    ans = '1' + ans;
                    break;
                }
            }
        }
        return ans;
    }
}
