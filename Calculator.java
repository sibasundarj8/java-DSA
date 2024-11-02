import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Double a = sc.nextDouble();
        char button = sc.next().charAt(0);
        Double b = sc.nextDouble();

        switch (button)
        {
            case '%' -> System.out.println(a % b);
            case '*' -> System.out.println(a * b);
            case '+' -> System.out.println(a + b);
            case '-' -> System.out.println(a - b);
            case '/' -> System.out.println(a / b);
            default -> System.out.println("Sorry, You entered a Invalid Operator\nPlease try again");
        }
    }
}