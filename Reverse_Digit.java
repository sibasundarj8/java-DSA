import java.util.Scanner;

public class Reverse_Digit
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int ans;
        for(ans = 0; n != 0; n /= 10)
        {
            ans = ans * 10 + n % 10;
        }

        System.out.println(ans);
    }
}