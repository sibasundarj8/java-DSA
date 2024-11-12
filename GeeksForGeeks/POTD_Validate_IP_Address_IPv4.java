package GFG;/*
 *   Q. You are given a string str in the form of an IPv4 Address. Your task is to validate
 *      an IPv4 Address, if it is valid return true otherwise return false.
 *
 *          IPv4 addresses are canonically represented in dot-decimal notation,
 *          which consists of four decimal numbers, each ranging from 0 to 255,
 *          separated by dots, e.g., 172.16.254.1
 *
 *          A valid IPv4 Address is of the form x1.x2.x3.x4 where 0 <= (x1, x2, x3, x4) <= 255.
 *          Thus, we can write the generalized form of an IPv4 address as,
 *          (0-255).(0-255).(0-255).(0-255)
 *
 *      Note: Here we are considering numbers only from 0 to 255 and any additional leading
 *            zeroes will be considered invalid.
 *
 *   Example :
 *        Input : str = 222.111.111.111
 *        Output: true
 *        Explanation:  Here, the IPv4 address is as per the criteria mentioned and also all
 *                      four decimal numbers lies in the mentioned range.
 *
 *        Input : str = 5555..555
 *        Output: false
 *        Explanation: 5555..555 is not a valid. IPv4 address, as the middle two portions are
 *                     missing.
 *
 */
import java.util.Scanner;

public class POTD_Validate_IP_Address_IPv4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IP Address :");
        String s = sc.next();
        System.out.println(isValid(s));
    }
    static boolean isValid(String s) {
        // potd.code.hub
        int n = s.length();
        int count = 0;
        for (int i = 0;i < n;i++){
            String temp = "";
            while(i < n && s.charAt(i) != '.')
                temp += s.charAt(i++);

            if (i < n && s.charAt(i)=='.') count++;
            if(count == 1 && !temp.isEmpty() && temp.charAt(0)=='0')return false;
            if (temp.isEmpty() || Integer.parseInt(temp) > 255)return false;
        }
        return count == 3;
    }
}