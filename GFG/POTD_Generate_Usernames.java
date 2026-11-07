package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/new-registration-system--150419/1
 *
 * # Generate Usernames
 *
 *   Q. Given an array of strings arr[]. The array represents first names of users, generate a unique username for
 *      each entry in the order it appears.
 *
 *      ◦ Initially, consider all usernames present in the input array as reserved.
 *      ◦ If a username has not already been assigned to any previous user, keep it unchanged.
 *      ◦ Otherwise, append the smallest positive integer suffix that produces a username that has not been reserved
 *        or assigned to any previous user.
 *
 *      Return the array of generated usernames.
 *
 *    Ex.
 *      Input : arr[] = ["a", "a", "a1", "a"]
 *      Output: ["a", "a2", "a1", "a3"]
 *      Explanation: Initially, "a" and "a1" are reserved. The first occurrence of "a" retains its name. For the
 *                   second occurrence, "a1" is already reserved, so the smallest available username is "a2". The
 *                   original "a1" retains its name when processed. Finally, the last occurrence of "a" gets "a3".
 *
 *  Constraints:
 *        ◦ 1 ≤ |arr| ≤ 10³
 *        ◦ 1 ≤ |arr[i]| ≤ 10²
 *        ◦ arr consists of English alphabets and digits
 */

import java.util.*;

public class POTD_Generate_Usernames {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("names[] : ");
        String[] names = sc.nextLine().split(" ");

        System.out.print("unique usernames: ");
        System.out.println(generateUsernames(names));
    }

    /// Solution
    static ArrayList<String> generateUsernames(String[] arr) {
        // potd.code.hub
        int n = arr.length;

        HashSet<String> processed = new HashSet<>();
        HashSet<String> seen = new HashSet<>(Arrays.asList(arr));

        HashMap<String, Integer> nextNum = new HashMap<>();

        ArrayList<String> result = new ArrayList<>(n);

        for (String name : arr) {
            if (processed.add(name)) {
                result.add(name);
                nextNum.put(name, 1);
            } else {
                int nxt = nextNum.get(name);

                while (true) {
                    String k = name + nxt;

                    if (!seen.contains(k)) {
                        seen.add(k);
                        result.add(k);
                        nextNum.put(name, nxt + 1);
                        break;
                    }

                    nxt++;
                }
            }
        }

        return result;
    }
}
