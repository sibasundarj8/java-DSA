package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/generate-ip-addresses/1
 *
 * # Generate IP Addresses
 *
 *   Q. Given a string s containing only digits, your task is to restore it by returning all possible
 *      valid IP address combinations. You can return your answer in any order.
 *
 *      A valid IP address must be in the form of A.B.C.D, where A, B, C, and D are numbers
 *      from 0-255(inclusive).
 *
 *      Note: The numbers cannot be 0 prefixed unless they are 0. For example, 1.1.2.11 and 0.11.21.1
 *            are valid IP addresses while 01.1.2.11 and 00.11.21.1 are not.
 *    Ex.
 *      Input : s = "255678166"
 *      Output: ["25.56.78.166",
 *               "255.6.78.166",
 *               "255.67.8.166",
 *               "255.67.81.66"]
 *      Explanation: These are the only valid possible IP addresses.
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_02_Generate_IP_Addresses {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String s = sc.next();

        System.out.println(generateIp(s));
    }

    /// Solution
    static ArrayList<String> generateIp(String s) {
        // potd.code.hub
        int n = s.length();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0;i < n-3;i++){
            for (int j = i+1;j < n-2;j++){
                for (int k = j+1;k < n-1;k++){
                    if (check(s,0,i) && check(s, i+1,j) && check(s,j+1,k) && check(s,k+1,n-1)){
                        list.add(s.substring(  0, i+1) + "." +
                                 s.substring(i+1, j+1) + "." +
                                 s.substring(j+1, k+1) + "." +
                                 s.substring(k+1, n));
                    }
                }
            }
        }

        return list;
    }
    private static boolean check(String s, int b, int e){
        if (e-b > 3 || (s.charAt(b) == '0' && e-b > 0)) return false;
        int temp = 0;
        while (b <= e){
            temp = temp * 10 + (s.charAt(b)-'0');
            b++;
        }
        return temp <= 255 && temp >= 0;
    }
}
