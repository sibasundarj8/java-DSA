import java.util.Scanner;

public class Odd_or_Even
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter a number");
        int a = sc.nextInt();

        if (a % 2 == 0)
        {
            System.out.println("even");
        } else {
            System.out.println("odd");
        }
    }
}