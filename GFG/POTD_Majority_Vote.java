package GFG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class POTD_Majority_Vote {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size:");
        int n = sc.nextInt();

        List<Integer>list = new ArrayList<>();

        System.out.println("Elements:");
        for (int i = 0;i < n;i++)
            list.add(sc.nextInt());

        System.out.println(findMajority(list));
    }
    static List<Integer> findMajority(List<Integer> nums){
        // potd.code.hub
        int n = nums.size();
        List<Integer>ans = new ArrayList<>();
        int el1 = -1,el2 = -1,freq1 = 0,freq2 = 0;
        // finding major elements
        for (Integer i : nums) {
            if (freq1 == 0 && i != el2) {
                el1 = i;
                freq1 = 1;
            }
            else if (freq2 == 0 && i != el1) {
                el2 = i;
                freq2 = 1;
            }
            else if (el1 == i) freq1++;
            else if (el2 == i) freq2++;
            else {
                freq1--;
                freq2--;
            }
        }
        // calculate answer is correct or not
        int count1 = 0,count2 = 0;
        for (Integer i : nums){
            if (el1 == i) count1++;
            if (el2 == i) count2++;
        }

        if (count1 > n/3) ans.add(el1);
        if (count2 > n/3) ans.add(el2);
        if (ans.isEmpty())ans.add(-1);
        Collections.sort(ans);

        return ans;
    }
}