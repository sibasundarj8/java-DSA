# CSES Problem: Repetitions

This repository contains the solution for the **"Repetitions"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1069).

## Problem Description

You are given a DNA sequence consisting of the characters **A, C, G, and T**. Your task is to determine the length of the longest contiguous substring that contains only one type of character.

In other words, find the maximum number of consecutive identical characters in the given string.

### Constraints

* $1 \le n \le 10^6$

### Example

**Input:**
```text
ATTCGGGA
```

**Output:**
```text
3
```

## Solution Approach

The solution uses a **single linear traversal** of the string to find the longest sequence of consecutive identical characters.

* **Logic:**
    * Start with a count of `1` for the first character.
    * Traverse the string from left to right.
    * If the current character is the same as the previous one, increment the current count.
    * Otherwise, update the maximum repetition found so far and reset the count to `1`.
    * After the traversal, perform one final update to ensure the last sequence is considered.

Since each character is visited exactly once, this approach is highly efficient even for the maximum input size.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

## Code Implementation (Java)

```java
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String dnaSequence = sc.next();

        int n = dnaSequence.length();
        int count = 1;
        int max = 0;

        for (int i = 1; i < n; i++) {
            if (dnaSequence.charAt(i - 1) == dnaSequence.charAt(i))
                count++;
            else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        max = Math.max(max, count);

        System.out.println(max);
    }
}
```

---
---------------------------ALL THE BEST---------------------------
---