# CSES Problem: Palindrome Reorder

This repository contains the solution for the **"Palindrome Reorder"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1755).

## Problem Description

Given a string consisting of uppercase English letters (`A-Z`), your task is to rearrange its characters so that the resulting string is a **palindrome**.

A palindrome reads the same forwards and backwards. If it is impossible to form such a string, print **"NO SOLUTION"**.

### Constraints

* $1 \le n \le 10^6$

### Example

**Input:**
```text
AAAACACBA
```

**Output:**
```text
AACABACAA
```

> **Note:** Any valid palindrome formed using the given characters is accepted.

## Solution Approach

The solution uses **character frequency counting** to construct the palindrome.

### Logic

* Count the frequency of each uppercase letter.
* A palindrome can have:
    * **At most one** character with an odd frequency.
    * All remaining characters must have even frequencies.
* If more than one character has an odd frequency, print **"NO SOLUTION"**.
* Otherwise:
    * Append half of each character's occurrences in alphabetical order.
    * Append the odd-frequency character (if any) in the middle.
    * Append the remaining halves in reverse alphabetical order.

This guarantees a valid palindrome whenever one exists.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)` (only a frequency array of size 26 is used)

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine().trim();

        int[] freq = new int[26];
        int oddCount = 0;

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq[i] & 1) == 1) {
                oddCount++;
            }
        }

        if (oddCount > 1) {
            System.out.println("NO SOLUTION");
            return;
        }

        char oddFreqChar = '$';

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;

            if ((freq[i] & 1) == 1) {
                oddFreqChar = (char) (i + 'A');
                continue;
            }

            bw.write(String.valueOf((char) (i + 'A')).repeat(freq[i] >> 1));
        }

        if (oddFreqChar != '$')
            bw.write(String.valueOf(oddFreqChar).repeat(freq[oddFreqChar - 'A']));

        for (int i = 25; i >= 0; i--) {
            if (freq[i] == 0 || (freq[i] & 1) == 1) continue;
            bw.write(String.valueOf((char) (i + 'A')).repeat(freq[i] >> 1));
        }

        br.close();
        bw.close();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------