import java.util.Scanner;

public class Inplace_Reverse {
    static void swapInArray(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] reverseArray(int[] num) {
        int n = num.length;
        int i = 0;

        for (int j = n - 1; i < j; --j) {
            swapInArray(num, i, j);
            ++i;
        }
        return num;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[] num = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for (int i = 0; i < num.length; ++i) {
            num[i] = sc.nextInt();
        }

        printArray(reverseArray(num));
    }
}