import java.util.Scanner;

public class Decimal_double_number_to_binary_string
{
    public static void main(String[] args)

    {
        Scanner sc = new Scanner(System.in)
                ;
        System.out.println("Print the Decimal double number: ");
        double n = sc.nextDouble();

        System.out.println("print the number of precision digits: ");
        int k = sc.nextInt();

        int decimal_n = (int)n;
        double fractional_n = n - (double)decimal_n;
        int decimal_binary = 0;

        for(int power = 1; decimal_n != 0; decimal_n /= 2)
        {
            int parity = decimal_n % 2;
            decimal_binary += parity * power;
            power *= 10;
        }

        StringBuilder s;
        for(s = new StringBuilder(decimal_binary + "."); k > 0 && fractional_n != 0.0; --k)
        {
            fractional_n *= 2.0;
            int digit = (int)fractional_n;
            s.append(digit);
            fractional_n -= digit;
        }
        System.out.println(s);
    }
}