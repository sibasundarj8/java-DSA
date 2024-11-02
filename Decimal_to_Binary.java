import java.util.Scanner;

public class Decimal_to_Binary
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number :");
        int n = sc.nextInt();

        long ans = 0L;

        for(long pw = 1L; n > 0; n /= 2)
        {
            int parity = n % 2;
            ans += parity * pw;
            pw *= 10L;
        }

        System.out.println("Binary Form is :");
        System.out.println(ans);
    }
}