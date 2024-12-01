package GFG;/*
 * # Nearest multiple of 10
 *
 *   Q. A string str is given to represent a positive number. The task is to round str to the
 *      nearest multiple of 10.  If you have two multiples equally apart from str, choose the
 *      smallest element among them.
 *   Ex.
 *      Input : str = 29
 *      Output: 30
 *      Explanation: Close multiples are 20 and 30, and 30 is the nearest to 29.
 */
import java.util.Scanner;

public class POTD_Nearest_multiple_of_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Number: ");
        String str = sc.next();
        System.out.println(roundToNearest(str));
    }
    static String roundToNearest(String str) {
        // potd.code.hub
        String ans = "0";
        int n = str.length();
        int lst = Integer.parseInt(String.valueOf(str.charAt(n-1)));
        if (lst == 0) return str;
        if (lst > 5){
            for (int i = n-2;i >= 0;i--){
                int temp = Integer.parseInt(String.valueOf(str.charAt(i)));
                if (temp != 9){
                    ans = str.substring(0,i) + (temp+1) + ans;
                    return ans;
                }
                ans += "0";
            }
            ans = "1" + ans;
        }
        else {
            ans = str.substring(0,n-1) + ans;
        }
        return ans;
    }
}