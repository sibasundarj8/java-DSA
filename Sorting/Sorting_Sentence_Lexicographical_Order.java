package Sorting;/*
 *     Q. WAP to arrange words Lexicographically.
 *
 *      Input  : n = 5
 *              arr[] = {book, note, apple, airplane, tiger}
 *      Output : airplane
 *               apple
 *               book
 *               note
 *               tiger
 */
import java.util.Scanner;

public class Sorting_Sentence_Lexicographical_Order {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        String[]arr = new String[n];
        System.out.println("Words :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.next();
        dictionaryOrder(arr, n);
        for (String i : arr)
            System.out.println(i);
    }
    static void dictionaryOrder(String[]arr,int n){
        for (int i = 0;i < n;i++){
            int min = i;
            for (int j = i+1;j < n;j++)
                if (arr[min].compareTo(arr[j]) >= 0) min = j;
            String temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }
}