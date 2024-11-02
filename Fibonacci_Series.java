import java.util.Scanner;

public class Fibonacci_Series
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size :");
        int n = sc.nextInt();

        long a = 0L;
        long b = 1L;

        for(int i = 0; i < n; ++i) {
            System.out.print(a + "  ");
            long sum = a + b;
            a = b;
            b = sum;
        }
    }
}