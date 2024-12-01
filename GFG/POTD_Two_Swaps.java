package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/*
         Q. Given a permutation of some of the first natural numbers in an array arr[], determine
            if the array can be sorted in exactly two swaps. A swap can involve the same pair of
            indices twice.

            Return true if it is possible to sort the array with exactly two swaps, otherwise return
            false.
       Ex.
          Input : arr = [4, 3, 2, 1]
          Output: true
          Explanation: First, swap arr[0] and arr[3]. The array becomes [1, 3, 2, 4]. Then, swap arr[1]
          and arr[2]. The array becomes [1, 2, 3, 4], which is sorted.
 */
public class POTD_Two_Swaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        List<Integer>arr = new ArrayList<>();

        System.out.println("1 >= Elements <= N");
        for (int i = 0;i < n;i++){
            arr.add(sc.nextInt());
        }

        System.out.println(checkSorted(arr));
    }
    static boolean checkSorted(List<Integer> arr) {
        // potd.code.hub
        int n = arr.size();
        int disPlace = 0;

        for (int i = 0;i < n;i++){
            if (arr.get(i) != i+1){
                disPlace++;
            }
        }

        if (disPlace == 1 || disPlace > n) return false;
        if (disPlace == 0 || disPlace == 3) return true;

        swapOnce(arr, n);
        swapOnce(arr, n);

        for (int i = 0;i < n;i++){
            if (arr.get(i) != i+1)return false;
        }
        return true;
    }
    static void swapOnce(List<Integer> arr, int n){
        for (int i = 0;i < n;i++){
            if (arr.get(i) != i+1){
                for (int j = i+1;j < n;j++){
                    if (arr.get(j) == i+1){
                        Collections.swap(arr, i, j);
                        return;
                    }
                }
            }
        }
    }
}