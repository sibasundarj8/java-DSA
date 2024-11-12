package Binary_Search;/*
 *   Q. You have ‘n’ game coins with you initially. The game has a coin increment system.
 *      Regardless of the amount of coins you possess, it adds ‘a’ amount of coins to your
 *      account every day for ‘m’ days. Exactly on ‘m + 1’ day, it adds ‘b’ coins to your
 *      account. This scenario repeats itself i.e. starting from day ‘m + 2’ you get ‘a’
 *      coins for ‘m’ days again and so on. Your task is to calculate the amount of time
 *      it will take for you to have at least ‘x’ (x <= 1000000) coins for the first time.
 *    Ex.
 *      Input : n = 2
 *              a = 5
 *              b = 3
 *              m = 4
 *              x = 51
 *     Output :
 *              11
 */
import java.util.Scanner;

public class Searching_Game_Coin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("The coin you already have :");
        int n = sc.nextInt();
        System.out.println("Daily coin :");
        int a = sc.nextInt();
        System.out.println("Special :");
        int b = sc.nextInt();
        System.out.println("Cycle day :");
        int m = sc.nextInt();
        System.out.println("Target :");
        int x = sc.nextInt();
        System.out.println(days(n,a,b,m,x));
    }
    static int days(int n,int a,int b,int m,int x){
        int l = 0,r = x;
        int ans = -1;
        while (l <= r){
            int mid = l + (r-l)/2;
            int rem = mid / (m+1);
            int temp = mid % (m+1);
            int ans2 = rem*(m*a+b)+temp*a+n;
            if (ans2 >= x){
                ans = mid;
                r = mid-1;
            }
            else l = mid+1;
        }
        return ans;
    }
}