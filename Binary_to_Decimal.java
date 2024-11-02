import java.util.Scanner;

public class Binary_to_Decimal
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int pw = 1;
        int ans = 0;

        for(long n = sc.nextInt(); n > 0L; n /= 10L)
        {
            long unitDigit = n % 10L;
            ans = (int)((long)ans + unitDigit * (long)pw);
            pw *= 2;
        }
        System.out.println(ans);
    }
}