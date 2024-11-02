import java.util.Scanner;

public class Middle_Character_of_a_String
{
    public static String middle(String s)
    {
        return s.length() % 2 == 0 ? s.substring((s.length() - 1) / 2, (s.length() - 1) / 2 + 2) : s.substring(s.length() / 2, s.length() / 2 + 1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your text : ");
        String s = sc.nextLine();

        System.out.println(middle(s));
    }
}