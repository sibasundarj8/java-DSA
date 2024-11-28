package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/repetitive-addition-of-digits2221/1
 *
 * # Repetitive Addition Of Digits
 *
 *   Q. You are given a positive integer n, you need to add all the digits of n and create a new number.
 *      Perform this operation until the resultant number has only one digit in it. Return the final
 *      number obtained after performing the given operation.
 *    Ex.
 *      Input: n = 5674
 *      Output: 4
 *      Explanation: Step 1: 5 + 6 + 7 + 4 = 22.
 *                   Step 2: 2 + 2 = 4
 */
import java.util.Scanner;

public class Array_02_Repetitive_Addition_Of_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Number: ");
        int n = sc.nextInt();

        System.out.println(singleDigit(n));
    }

    /// Solution
    static int singleDigit(int n) {
        // potd.code.hub
        int num = n;
        while (num/10 != 0){
            num = digitSum(num);
        }
        return num;
    }
    static int digitSum(int num){
        int ans = 0;
        while(num != 0){
            ans += num%10;
            num /= 10;
        }

        return ans;
    }
}
