# CSES Problem: Creating Strings

This repository contains the solution for the **"Creating Strings"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1622).

## Problem Description

Given a string containing lowercase English letters, your task is to generate **all distinct strings** that can be created by rearranging its characters.

The generated strings must be printed in **alphabetical order**.

### Constraints

* $1 \le n \le 8$

### Example

**Input:**

```text
aabac
```

**Output:**

```text
20
aaabc
aaacb
aabac
aabca
aacab
aacba
abaac
abaca
abcaa
acaab
acaba
acbaa
baaac
baaca
bacaa
bcaaa
caaab
caaba
cabaa
cbaaa
```

## Solution Approach

The solution uses **frequency counting and backtracking** to generate all distinct permutations without producing duplicates.

### Logic

* Count the frequency of each character using an array of size `26`.
* Calculate the total number of distinct permutations using:

$$
\frac{n!}{f_1! \times f_2! \times \cdots \times f_{26}!}
$$

where `fᵢ` represents the frequency of each character.

* Use **backtracking** to construct every possible string:

    * At each position, try every character whose remaining frequency is greater than zero.
    * Decrease its frequency before the recursive call.
    * Restore the frequency after returning from recursion.
* Characters are considered from `'a'` to `'z'`, so the generated strings naturally appear in **lexicographical order**.
* Using character frequencies ensures that identical characters are not treated as separate choices, preventing duplicate permutations.

### Complexity

Let `k` be the number of distinct permutations.

* **Time Complexity:** `O(n × k)` for generating and printing all permutations.
* **Space Complexity:** `O(n)` for the recursion stack and temporary string.

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    private final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private final static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int[] fact = new int[10];

    static {
        fact[0] = 1;

        for (int i = 1; i < 10; i++) {
            fact[i] = fact[i - 1] * i;
        }
    }

    public static void main(String[] args) throws IOException {
        String s = br.readLine().trim();

        int n = s.length();
        int[] freq = new int[26];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }

        int count = fact[n];

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            count /= fact[freq[i]];
        }

        bw.write(String.valueOf(count));
        bw.newLine();

        new Solution().printCombinations(0, n, freq, new char[n]);

        bw.flush();
    }

    private void printCombinations(int idx, int n, int[] freq, char[] temp) throws IOException {

        // Base case
        if (idx >= n) {
            bw.write(temp);
            bw.newLine();
            return;
        }

        // Try characters in alphabetical order
        for (int x = 0; x < 26; x++) {
            if (freq[x] == 0) continue;
            
            // use
            freq[x]--;

            temp[idx] = (char) (x + 'a');
            printCombinations(idx + 1, n, freq, temp);

            // backtrack
            freq[x]++;
        }
    }
}
```

---

# ---------------------------- THANK YOU ----------------------------
