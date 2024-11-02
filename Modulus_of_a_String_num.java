import java.util.Scanner;

public class Modulus_of_a_String_num
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a big positive number: ");
        String x = sc.nextLine();

        int rem = 0;
        for(int i = 0; i < x.length(); ++i)
        {
            int digit = Integer.parseInt(String.valueOf(x.charAt(i)));
            rem = (rem * 10 + digit) % 11;
        }

        System.out.println("x % 11 = " + rem);
    }
}