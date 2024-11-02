import java.util.Scanner;

public class Power_of_a_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        long ans = 1L;

        for(int j = 1; j <= b; ++j)
        {
            ans *= a;
        }
        System.out.println(ans);
    }
}