package Recursion;/*
 *     Q5. Given a string, recursively implement atoI() or Integer.parseInt() method
 *         on it without actually using the method.
 *       Ex.-
 *          Input :- 298
 *          Output:- 298
 *
 *      Explanation:-
 *          ●   atoI() function of  C++  or Integer.parseInt() method of java takes
 *              a string (which represents an integer) as an argument  and  returns
 *              its value, so it looks the same but is of different data type.
 *
 *          ●   To convert a string to integer, we need to pick the first character,
 *              convert it into integer by subtracting ‘0’ character from it  as ‘0’
 *              has the initial ASCII code value and serial numbers have consecutive
 *              ASCII values as in the decimal system, all values are set in relation
 *              to 0.
 *
 *          ●   for example, atoI(982) is calculated in following manner:
 *
 *                      "982"
 *                      /  \
 *                     9   "82"
 *                    /     /\
 *                   90    8 "2"
 *                    \   /   /\
 *                      98   2  ""
 *                       |
 *                      982
 *
 *          ●   We keep picking the characters from start  of  the  string, multiply
 *              current ans by 10 and then add the next character to ans.
 *
 *          ●   To do it recursively, we do it in a reverse fashion.
 *
 *          ●   We call a recursive function for string from first  index  to second
 *              last index, and add last digit to this ans.
 *
 *          ●   We create a recursive function with  string  and  index as  length of
 *              string as its arguments.
 *
 *          ●   Our base case is if nll0, which  means we  are  the  first  character,
 *              so just convert it to digit and return.
 *
 *          ●   Call the recursive function with string and n-1 as arguments, multiply
 *              this with 10 and add last digit to this and return.
 */
import java.util.Scanner;

public class Recursion_34_String_Change_Datatype
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number :");
        String x = sc.nextLine();

        System.out.println(convertDatatype(x,x.length()-1));
    }
    static int convertDatatype(String s, int idx)
    {
        // Base Case
        if (idx == 0)return s.charAt(idx)-'0';

        // Recursive Function
        return convertDatatype(s,idx-1)*10 + (s.charAt(idx)-'0');
    }
}