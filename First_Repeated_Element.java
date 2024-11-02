import java.util.Scanner;

public class First_Repeated_Element
{
    static int firstRepeat(int[] arr)
    {
        for(int i = 0; i < arr.length; ++i)
        {
            for(int j = i + 1; j < arr.length; ++j)
            {
                if (arr[i] == arr[j])
                {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[] num = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for(int i = 0; i < num.length; ++i)
        {
            num[i] = sc.nextInt();
        }

        System.out.println("The First Repeating Element is : " + firstRepeat(num));
    }
}