import java.util.Scanner;

public class Count_the_Number_of_Digits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int original_n = n;

        int count;
        for(count = 0; original_n > 0; ++count) {
            original_n /= 10;
        }

        System.out.println("There are " + count + " Numbers in " + n);
    }
}