package Array;/*
 *    Q. Given 3 sorted arrays of different sizes, you have to find the common elements
 *       of that 3 arrays. If there is no such common elements are present, return -1.
 *     Ex.
 *       Input : Size of 3 arrays : 3 6 9
 *               a[] = 1 5 9
 *               b[] = 1 3 5 7 9 11
 *               c[] = 1 2 3 4 5 6 7 8 9
 *      Output : [1, 5, 9]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Array_Common_in_3_Sorted_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of a[], b[], c[] :");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int n3 = sc.nextInt();
        int[]a = new int[n1];
        int[]b = new int[n2];
        int []c = new int[n3];
        System.out.println("a[] Elements :");
        for (int i = 0;i < n1;i++)a[i] = sc.nextInt();
        System.out.println("b[] Elements :");
        for (int i = 0;i < n2;i++)b[i] = sc.nextInt();
        System.out.println("c[] Elements :");
        for (int i = 0;i < n3;i++)c[i] = sc.nextInt();
        System.out.println(commonElements(a,b,c,n1,n2,n3));
    }
    static ArrayList<Integer> commonElements(int[]a, int[]b, int[]c, int n1, int n2, int n3)
    {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;

        while (i<n1 && j<n2 && k<n3){
            if (a[i] == b[j] && b[j] == c[k]){
                ans.add(a[i]);
                i++;
                j++;
                k++;
            }
            else if (a[i] == b[j] && c[k] < b[j]) k++;
            else if (a[i] == b[j] && c[k] > b[j]){
                i++;
                j++;
            }
            else if (a[i] == c[k] && b[j] < c[k]) j++;
            else if (a[i] == c[k] && b[j] > c[k]){
                i++;
                k++;
            }
            else if (c[k] == b[j] && a[i] < b[j]) i++;
            else if (c[k] == b[j] && a[i] > b[j]){
                k++;
                j++;
            }
            else if (a[i] > b[j] && a[i] > c[k]){
                j++;
                k++;
            }
            else if (b[j] > a[i] && b[j] > c[k]){
                i++;
                k++;
            }
            else if (c[k] > b[j] && c[k] > a[i]){
                j++;
                i++;
            }
        }
        if (ans.isEmpty())ans.add(-1);
        ArrayList<Integer>ans1 = new ArrayList<>();
        ans1.add(ans.get(0));
        for (int z = 1;z < ans.size();z++){
            if (!ans.get(z).equals(ans.get(z-1))) {
                ans1.add(ans.get(z));
            }
        }
        return ans1;
    }
}
