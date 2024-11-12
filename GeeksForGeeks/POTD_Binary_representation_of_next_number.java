package GFG;/*
 *  Q.  Given a binary representation in the form of a string(s) of a
 *      number n, the task is to find a binary representation of n+1.
 *
 *   Example :
 *      Input: s = "10"
 *      Output: 11
 *      Explanation: "10" is the binary representation of 2 and
 *                    binary representation of 3 is "11"
 */
import java.util.Arrays;
import java.util.Scanner;

public class POTD_Binary_representation_of_next_number {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Binary String :");
        String s = sc.next();
        System.out.println(binaryNextNumber(s));
    }
    static String binaryNextNumber(String s){
        // code here.
        char[]ans = s.toCharArray();
        int n = ans.length;
        int carry = 1;
        for (int i = n-1;i >= 0 && carry == 1;i--) {
            if (ans[i] == '0') {
                ans[i] = '1';
                carry = 0;
            }
            else {
                ans[i] = '0';
            }
        }
        if (carry == 1)return '1' + String.valueOf(ans);
        int idx = 0;
        while (idx < n && ans[idx] == '0')idx++;
        return String.valueOf(Arrays.copyOfRange(ans,idx,n));
    }
}