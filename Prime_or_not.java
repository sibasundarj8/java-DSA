import java.util.Scanner;

public class Prime_or_not
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        for(int j = 0; j < 5; ++j)
        {
            int a = sc.nextInt();
            int count = 0;

            for(int i = 1; i <= a; ++i)
            {
                if (a % i == 0)
                {
                    ++count;
                }
            }

            if (count == 2)
            {
                System.out.println("it is Prime");
            } else {
                System.out.println("it is not Prime");
            }
        }
    }
}