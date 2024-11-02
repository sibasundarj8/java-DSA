import java.util.Scanner;

public class Largest_Water_Container
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];

        System.out.print("Array Elements : ");
        int i;
        for(i = 0; i < arr.length; ++i)
        {
            arr[i] = sc.nextInt();
        }

        i = 0;
        int j = arr.length - 1;
        int ans = 0;

        while(i < j)
        {
            int ht = Math.min(arr[i], arr[j]);
            int width = j - i;
            int area = ht * width;
            ans = Math.max(ans, area);

            if (arr[i] < arr[j])
            {
                ++i;
            } else {
                --j;
            }
        }
        System.out.println(ans);
    }
}