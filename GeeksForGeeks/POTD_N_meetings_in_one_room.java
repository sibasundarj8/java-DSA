package GFG;

import java.util.Scanner;

public class POTD_N_meetings_in_one_room {
    static int minSwaps(String s) {
        // potd.code.hub
        int odd = 0;
        int even = 0;
        for (int i = 0;i < s.length();i++){
            if(i%2 == 0){
                if (s.charAt(i) == '1')even++;
            }
            else if (s.charAt(i) == '1')odd++;
        }
        if ((odd+even)%2 == 1)return -1;
        int ans = (odd + even)/2;
        return Math.abs(even-ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(minSwaps(s));
    }
}