import java.util.Scanner;

public class Leap_year
{
    public static boolean is_LeapYear(int y)
    {
        boolean a = y % 4 == 0;
        boolean b = (y & 100) != 0;
        boolean c = y % 100 == 0 && y % 400 == 0;
        return a && (b || c);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Year : ");
        int year = sc.nextInt();

        System.out.println(is_LeapYear(year));
    }
}