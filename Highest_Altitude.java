import java.util.Scanner;

public class Highest_Altitude
{
    static int highestAltitude(int[] num) {
        int max = 0, count = 0;

        for (int i : num) {
            count += i;
            if (max < count)
            {
                max = count;
            }
        }
        return max;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];

        System.out.print("Array Elements : ");
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println("The Highest Altitude is : " + highestAltitude(arr));
    }
}