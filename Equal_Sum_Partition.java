import java.util.Scanner;

public class Equal_Sum_Partition
{
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
        System.out.println(equalSumPartition(arr));
    }

    static int totalSum(int[] arr) {
        int sum = 0;

        for (int i : arr)
        {
            sum += i;
        }
        return sum;
    }
    static boolean equalSumPartition(int[] arr) {
        int totalSum = totalSum(arr);
        int prefixSum = 0;

        for (int j : arr)
        {
            prefixSum += j;
            int suffixSum = totalSum - prefixSum;
            if (suffixSum == prefixSum) {
                return true;
            }
        }
        return false;
    }
}