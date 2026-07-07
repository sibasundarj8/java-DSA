# CSES Problem: Two Sets

This repository contains the solution for the **"Two Sets"** problem from the [CSES Problem Set](https://cses.fi/problemset/task/1092).

## Problem Description

You are given the integers **1, 2, ..., n**. Your task is to divide these numbers into **two sets** such that the sum of the elements in both sets is equal.

If such a partition is impossible, print **"NO"**. Otherwise, print **"YES"** followed by one valid partition.

### Constraints

* $1 \le n \le 10^6$

### Examples

**Example 1**

**Input:**
```text
7
```

**Output:**
```text
YES
4
1 2 4 7
3
3 5 6
```

**Example 2**

**Input:**
```text
6
```

**Output:**
```text
NO
```

## Solution Approach

The solution uses a **greedy approach** to construct one of the two sets.

* **Logic:**
    * Compute the total sum of the numbers from `1` to `n`:
        * $\frac{n(n+1)}{2}$
    * If the total sum is **odd**, it is impossible to divide it into two equal halves, so print **"NO"**.
    * Otherwise, the target sum for each set is `totalSum / 2`.
    * Starting from the largest number (`n`) and moving downward:
        * If the current number does not exceed the remaining target, include it in the first set.
        * Subtract its value from the target.
        * Continue until the target becomes zero.
    * The remaining numbers automatically form the second set.

Since larger numbers reduce the target more quickly, the greedy strategy successfully constructs a valid partition whenever one exists.

### Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(n)`

## Code Implementation (Java)

```java
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());
        long totalSum = (n * (n + 1L)) >> 1;

        if ((totalSum & 1) == 1) {
            bw.write("NO\n");
            bw.flush();
            return;
        }

        int set1Size = 0;
        boolean[] set1 = new boolean[n + 1];
        long target = totalSum >> 1;

        for (int i = n; i > 0; i--) {
            if (i <= target) {
                target -= i;
                set1[i] = true;
                set1Size++;

                if (target == 0) break;
            }
        }

        bw.write("YES\n");
        bw.write(String.valueOf(set1Size));
        bw.write('\n');

        for (int i = 1; i <= n; i++) {
            if (set1[i]) {
                bw.write(String.valueOf(i));
                bw.write(' ');
            }
        }

        bw.write('\n');
        bw.write(String.valueOf(n - set1Size));
        bw.write('\n');

        for (int i = 1; i <= n; i++) {
            if (!set1[i]) {
                bw.write(String.valueOf(i));
                bw.write(' ');
            }
        }

        bw.write('\n');
        bw.flush();
    }
}
```

---
# ---------------------------ALL THE BEST---------------------------