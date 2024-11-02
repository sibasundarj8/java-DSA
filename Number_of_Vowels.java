import java.util.Scanner;

public class Number_of_Vowels
{
    public static int count(String s)
    {
        int count = 0;

        for(int i = 0; i < s.length(); ++i)
        {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U')
            {
                ++count;
            }
        }
        return count;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String : ");
        String s = sc.nextLine();

        System.out.println("Number of Vowels : " + count(s));
    }
}