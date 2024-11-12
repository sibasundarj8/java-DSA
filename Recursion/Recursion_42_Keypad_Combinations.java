package Recursion;/*
 *   Q.  Given a String containing  from 2-9 inclusive  return all  possible  letter
 *       combinations that the number could represent. Return the Answer in any order.
 *    Ex :-
 *      Input : Digits : "23"
 *     Output : "ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"
 *
 *    ** Inspired from Phone Call dial ped.
 */

import java.util.Scanner;

public class Recursion_42_Keypad_Combinations
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number :");
        String s = sc.next();

        // Keypad Letters
        String[]keyMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
                   /*      0  1   2     3     4     5     6      7     8      9     */

        keyCombinations(s,keyMap,"");
    }
    static void keyCombinations(String dig,String[]kp,String ans)
    {
        // Base Case
        if (dig.isEmpty()) {
            System.out.println(ans);
            return;
        }
        // Self Work
        int currentNum = dig.charAt(0) - '0';
        String currentChoices = kp[currentNum];

        // Recursive Work
        for (int i = 0;i < currentChoices.length();i++){
            keyCombinations(dig.substring(1),kp,ans+currentChoices.charAt(i));
        }
    }
}