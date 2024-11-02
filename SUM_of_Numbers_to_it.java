import java.util.Scanner;

public class SUM_of_Numbers_to_it
{                                                          // big - O( 1 )
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = sc.nextInt();

        System.out.println(n * (n + 1) / 2);
    }
}