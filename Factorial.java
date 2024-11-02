import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Factorial
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();

        AtomicInteger y = new AtomicInteger(x);

        for(int i = x - 1; i > 0; --i)
        {
            int finalI = i;
            y.updateAndGet((v) -> v * finalI);
        }

        System.out.println("factorial of " + x + " is " + y);
    }
}